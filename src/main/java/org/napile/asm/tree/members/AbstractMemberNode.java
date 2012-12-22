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
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.Name;

/**
 * @author VISTALL
 * @date 17:32/31.08.12
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMemberNode<T extends AbstractMemberNode<T>> extends AnnotableNode<T>
{
	@NotNull
	public final Modifier[] modifiers;

	@NotNull
	public final List<TypeParameterNode> typeParameters = new ArrayList<TypeParameterNode>(0);

	public ClassNode parent;

	public AbstractMemberNode(@NotNull Modifier[] modifiers)
	{
		this.modifiers = Modifier.list(modifiers);
	}

	public TypeParameterNode visitTypeParameter(@NotNull Name name)
	{
		TypeParameterNode typeParameterNode = new TypeParameterNode(name);

		typeParameters.add(typeParameterNode);

		return typeParameterNode;
	}
}
