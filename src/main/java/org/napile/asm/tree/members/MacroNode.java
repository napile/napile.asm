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
import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 20:54/18.11.12
 */
public class MacroNode extends LikeMethodNode<MacroNode>
{
	/**
	 * The method's name.
	 */
	public Name name;
	/**
	 * Return type of method
	 */
	@NotNull
	public TypeNode returnType = AsmConstants.NULL_TYPE;

	/**
	 * Parameters of method
	 */
	@NotNull
	public final List<MethodParameterNode> parameters = new ArrayList<MethodParameterNode>(0);

	public MacroNode(@NotNull Modifier[] modifiers, @NotNull Name name)
	{
		super(modifiers);
		this.name = name;
	}

	// ------------------------------------------------------------------------
	// Accept method
	// ------------------------------------------------------------------------
	@Override
	public <T, R> R accept(@org.jetbrains.annotations.NotNull final NodeVisitor<T, R> asmVisitor, T a2)
	{
		return asmVisitor.visitMacroNode(this, a2);
	}
}
