/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.napile.asm.firstTests;

import java.util.Collections;

import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.bytecode.VariableRef;
import org.napile.asm.tree.members.bytecode.impl.InvokeStaticInstruction;
import org.napile.asm.tree.members.bytecode.impl.LoadInstruction;
import org.napile.asm.tree.members.bytecode.impl.NewIntInstruction;
import org.napile.asm.tree.members.bytecode.impl.NewObjectInstruction;
import org.napile.asm.tree.members.bytecode.impl.PutToStaticVariableInstruction;
import org.napile.asm.tree.members.bytecode.impl.StoreInstruction;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.AsmBuilder;
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;

/**
 * @author VISTALL
 * @date 1:12/14.08.12
 */
public class NodeUtil
{
	static AsmBuilder createTestClassNode()
	{
		AsmBuilder asmBuilder = new AsmBuilder();
		asmBuilder.visitClass(Modifier.list(Modifier.ABSTRACT), NapileLangPackage.INT).visitSuper(NapileLangPackage.ANY);
		asmBuilder.visitTypeParameter("E");

		MethodNode methodNode = asmBuilder.visitMethod(Modifier.list(Modifier.STATIC), "main");
		asmBuilder.visitMethodParameter(true, "arg", asmBuilder.createTypeOfClass("napile.lang.Array").visitArgument(asmBuilder.createTypeOfClass(NapileLangPackage.STRING))) ;

		methodNode.returnType = new TypeNode(false, new ThisTypeNode());
		methodNode.maxLocals = 2;
		methodNode.instructions.add(new NewIntInstruction(1234));
		methodNode.instructions.add(new StoreInstruction(1));
		methodNode.instructions.add(new LoadInstruction(1));
		methodNode.instructions.add(new InvokeStaticInstruction(new MethodRef(new FqName("Console.write"), Collections.singletonList(asmBuilder.createTypeOfClass(NapileLangPackage.INT)), null)));

		methodNode.instructions.add(new NewObjectInstruction(asmBuilder.createTypeOfClass(NapileLangPackage.ANY)));
		methodNode.instructions.add(new PutToStaticVariableInstruction(new VariableRef(NapileLangPackage.ANY.child(Name.identifier("Test")), new TypeNode(false, new TypeParameterValueTypeNode("E")))));

		VariableNode variableNode = asmBuilder.visitVariable(Modifier.list(Modifier.NATIVE), "myVar");
		variableNode.returnType = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

		return asmBuilder;
	}
}
