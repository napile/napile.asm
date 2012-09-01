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

package org.napile.asm.tree.members.types;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.AnnotableNode;
import org.napile.asmNew.visitors.AsmVisitor;

/**
 * @author VISTALL
 * @date 0:18/14.08.12
 */
public class TypeNode extends AnnotableNode<TypeNode>
{
	public final boolean nullable;
	@NotNull
	public final TypeConstructorNode typeConstructorNode;

	public List<TypeNode> arguments = new ArrayList<TypeNode>(0);

	public TypeNode(boolean nullable, @NotNull TypeConstructorNode typeConstructorNode)
	{
		this.nullable = nullable;
		this.typeConstructorNode = typeConstructorNode;
	}

	@NotNull
	public TypeNode visitArgument(@NotNull TypeNode typeNode)
	{
		arguments.add(typeNode);
		return this;
	}

	@Override
	public <T> void accept(@NotNull AsmVisitor<T> visitor, T arg)
	{
		visitor.visitTypeNode(this, arg);
	}
}
