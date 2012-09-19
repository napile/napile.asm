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

/**
 * @author VISTALL
 * @date 18:23/06.09.12
 */
public class ConstructorNode extends LikeMethodNode<ConstructorNode>
{
	/**
	 * Parameters of method
	 */
	@NotNull
	public final List<MethodParameterNode> parameters = new ArrayList<MethodParameterNode>(0);

	public ConstructorNode(@NotNull Modifier[] modifiers)
	{
		super(modifiers);
	}

	@Override
	public <T> void accept(@NotNull NodeVisitor<T> visitor, T arg)
	{
		visitor.visitConstructorNode(this, arg);
	}
}