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

import org.napile.asm.AsmBuilder;
import org.napile.asm.Modifier;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.types.TypeNode;
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
		asmBuilder.visitClass(Modifier.list(Modifier.ABSTRACT), NapileLangPackage.INT).visitSuper(NapileLangPackage.ANY);
		asmBuilder.visitTypeParameter("E");

		MethodNode methodNode = asmBuilder.visitMethod(Modifier.list(Modifier.STATIC), "main");
		methodNode.typeParameters.add(new TypeParameterNode("E"));
		asmBuilder.visitMethodParameter(true, "arg", asmBuilder.createTypeOfClass("napile.lang.Array").visitArgument(asmBuilder.createTypeOfClass(NapileLangPackage.STRING))) ;

		methodNode.returnType = new TypeNode(false, new ThisTypeNode());

		//VariableNode variableNode = asmBuilder.visitVariable(Modifier.list(Modifier.NATIVE), "myVar");
		//variableNode.returnType = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

		return asmBuilder;
	}
}
