/*
 * Copyright 2010-2012 napile.org
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

package org.napile.asm.tree.members;

import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.MethodTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;

/**
 * @author VISTALL
 * @date 22:20/13.08.12
 */
public interface NodeVisitor<A, R>
{
	R visitAnnotationNode(AnnotationNode annotationNode, A a2);

	R visitClassNode(ClassNode classNode, A a2);

	R visitMethodNode(MethodNode methodNode, A a2);

	R visitMacroNode(MacroNode methodNode, A a2);

	R visitVariableNode(VariableNode variableNode, A a2);

	R visitMethodParameterNode(MethodParameterNode methodParameterNode, A a2);

	R visitTypeParameter(TypeParameterNode typeParameterNode, A a2);

	R visitTypeNode(TypeNode typeNode, A a2);

	R visitClassTypeNode(ClassTypeNode classTypeNode, A a2);

	R visitThisTypeNode(ThisTypeNode thisTypeNode, A a2);

	R visitMethodTypeNode(MethodTypeNode methodTypeNode, A a2);

	R visitTypeParameterValueTypeNode(TypeParameterValueTypeNode typeParameterValueTypeNode, A a2);

	R visitTryCatchBlockNode(TryCatchBlockNode tryCatchBlockNode, A a2);
}
