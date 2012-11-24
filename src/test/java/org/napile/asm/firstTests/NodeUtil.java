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

import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.MethodTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;

/**
 * @author VISTALL
 * @date 1:12/14.08.12
 */
public class NodeUtil
{
	static ClassNode createTestClassNode()
	{
		ClassNode classNode = new ClassNode(Modifier.list(Modifier.ABSTRACT), NapileLangPackage.INT).visitSuper(AsmConstants.ANY_TYPE);
		TypeParameterNode typeParameterNode = classNode.visitTypeParameter(Name.identifier("E"));
		typeParameterNode.constructors.add(Arrays.asList(new MethodParameterNode(Modifier.EMPTY, Name.identifier("test"), AsmConstants.INT_TYPE), new MethodParameterNode(Modifier.EMPTY, Name.identifier("test2"), new TypeNode(false, new ClassTypeNode(NapileLangPackage.THROWABLE)))));
		typeParameterNode.constructors.add(Arrays.asList(new MethodParameterNode(Modifier.EMPTY, Name.identifier("test3"), new TypeNode(true, new ClassTypeNode(NapileLangPackage.THROWABLE))), new MethodParameterNode(Modifier.EMPTY, Name.identifier("test4"), new TypeNode(false, new ClassTypeNode(NapileLangPackage.STRING)))));

		MethodNode methodNode = new MethodNode(Modifier.list(Modifier.STATIC), Name.identifier("main"));
		methodNode.typeParameters.add(new TypeParameterNode(Name.identifier("E")));
		methodNode.parameters.add(new MethodParameterNode(Modifier.list(Modifier.FINAL), Name.identifier("arg"), AsmConstants.ARRAY__STRING__TYPE));
		methodNode.returnType = new TypeNode(false, new ThisTypeNode());
		classNode.members.add(methodNode);

		VariableNode variableNode = new VariableNode(Modifier.list(Modifier.NATIVE), Name.identifier("myVar"));
		variableNode.returnType = AsmConstants.INT_TYPE;
		classNode.members.add(variableNode);

		MethodNode methodNode2 = new MethodNode(Modifier.EMPTY, Name.identifier("methodWithParameter"));
		MethodTypeNode methodTypeNode = new MethodTypeNode();
		methodTypeNode.parameters.add(new MethodParameterNode(Modifier.EMPTY, Name.identifier("p1"), AsmConstants.BOOL_TYPE));
		methodNode2.returnType = new TypeNode(false, methodTypeNode);

		classNode.members.add(methodNode2);

		ConstructorNode constructorNode = new ConstructorNode(Modifier.EMPTY);
		classNode.members.add(constructorNode);

		return classNode;
	}
}
