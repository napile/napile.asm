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

package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:29/02.09.12
 */
public class NewStringInstruction implements Instruction
{
	@NotNull
	public final String value;

	public NewStringInstruction(@NotNull String value)
	{
		this.value = value;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitNewString(this, a2);
	}

	@Override
	public String toString()
	{
		return "new_string: " + value;
	}
}
