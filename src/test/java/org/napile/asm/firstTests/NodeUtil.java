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

import java.util.Arrays;
import java.util.List;

import org.napile.asm.AsmBuilder;
import org.napile.asm.Modifier;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.ConstructorNode;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.bytecode.tryCatch.CatchBlock;
import org.napile.asm.tree.members.bytecode.tryCatch.TryBlock;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;

/**
 * @author VISTALL
 * @date 1:12/14.08.12
 */
public class NodeUtil
{
	static AsmBuilder createTestClassNode()
	{
		AsmBuilder asmBuilder = new AsmBuilder();
		ClassNode classNode = asmBuilder.visitClass(Modifier.list(Modifier.ABSTRACT), NapileLangPackage.INT).visitSuper(NapileLangPackage.ANY);
		TypeParameterNode typeParameterNode = asmBuilder.visitTypeParameter("E");
		typeParameterNode.constructors.add(Arrays.asList(new MethodParameterNode(Modifier.EMPTY, "test", new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT))), new MethodParameterNode(Modifier.EMPTY, "test2", new TypeNode(false, new ClassTypeNode(NapileLangPackage.THROWABLE)))));
		typeParameterNode.constructors.add(Arrays.asList(new MethodParameterNode(Modifier.EMPTY, "2", new TypeNode(true, new ClassTypeNode(NapileLangPackage.THROWABLE))), new MethodParameterNode(Modifier.EMPTY, "1", new TypeNode(false, new ClassTypeNode(NapileLangPackage.STRING)))));

		MethodNode methodNode = asmBuilder.visitMethod(Modifier.list(Modifier.STATIC), "main");
		methodNode.typeParameters.add(new TypeParameterNode("E"));
		asmBuilder.visitMethodParameter(true, "arg", asmBuilder.createTypeOfClass("napile.lang.Array").visitArgument(asmBuilder.createTypeOfClass(NapileLangPackage.STRING))) ;

		methodNode.returnType = new TypeNode(false, new ThisTypeNode());

		TryBlock tryBlock = new TryBlock(0, 15);
		List<CatchBlock> list = Arrays.asList(new CatchBlock(16, 17, 0, new TypeNode(false, new ClassTypeNode(NapileLangPackage.THROWABLE))));
		methodNode.tryCatchBlockNodes.add(new TryCatchBlockNode(tryBlock, list));

		VariableNode variableNode = asmBuilder.visitVariable(Modifier.list(Modifier.NATIVE), "myVar");
		variableNode.returnType = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

		ConstructorNode constructorNode = new ConstructorNode(Modifier.EMPTY);
		classNode.members.add(constructorNode);

		return asmBuilder;
	}
}
