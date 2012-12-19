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

import org.jetbrains.annotations.NotNull;
import org.napile.asm.Modifier;
import org.napile.asm.ModifierType;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * A node that represents a field.
 *
 * @author VISTALL
 *
 * base idea was get from ObjectWeb Asm
 */
public class VariableNode extends AbstractMemberNode<VariableNode>
{
	@NotNull
	public final Name name;

	@NotNull
	public TypeNode returnType;

	public final boolean mutable;

	public VariableNode(@NotNull Modifier[] modifiers, @NotNull Name name, boolean mutable)
	{
		super(modifiers);
		this.name = name;
		this.mutable = mutable;
		for(Modifier m : modifiers)
			if(m.getModifierType() == ModifierType.ACCESS)
				throw new IllegalArgumentException("Variable cant have access modifier");
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitVariableNode(this, arg);
	}
}
