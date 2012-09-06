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

import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.tree.members.types.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 22:20/13.08.12
 */
public interface NodeVisitor<A2>
{
	void visitAnnotationNode(AnnotationNode annotationNode, A2 a2);

	void visitClassNode(ClassNode classNode, A2 a2);

	void visitMethodNode(MethodNode methodNode, A2 a2);

	void visitConstructorNode(ConstructorNode constructorNode, A2 a2);

	void visitVariableNode(VariableNode variableNode, A2 arg);

	void visitMethodParameterNode(MethodParameterNode methodParameterNode, A2 a2);

	void visitTypeParameter(TypeParameterNode typeParameterNode, A2 a2);

	void visitTypeNode(TypeNode typeNode, A2 a2);

	void visitClassTypeNode(ClassTypeNode classTypeNode, A2 a2);

	void visitThisTypeNode(ThisTypeNode thisTypeNode, A2 a2);
}
