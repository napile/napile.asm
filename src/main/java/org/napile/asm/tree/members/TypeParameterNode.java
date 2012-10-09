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

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 18:33/31.08.12
 */
public class TypeParameterNode extends AnnotableNode<TypeParameterNode>
{
	@NotNull
	public final List<TypeNode> supers = new ArrayList<TypeNode>(1);

	@NotNull
	public final List<List<MethodParameterNode>> constructors = new ArrayList<List<MethodParameterNode>>(0);

	@NotNull
	public final String name;

	public TypeParameterNode(@NotNull String name)
	{
		this.name = name;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitTypeParameter(this, arg);
	}
}
