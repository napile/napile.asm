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
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.adapter.InstructionAdapter;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;

/**
 * @author VISTALL
 * @date 18:21/06.09.12
 */
public abstract class LikeMethodNode<T extends LikeMethodNode<T>> extends AbstractMemberNode<T>
{
	/**
	 * Code instruction
	 */
	@NotNull
	public final List<Instruction> instructions = new ArrayList<Instruction>(0);

	@NotNull
	public final List<TryCatchBlockNode> tryCatchBlockNodes = new ArrayList<TryCatchBlockNode>(0);
	/**
	 * The maximum number of local variables of this method.
	 */
	public int maxLocals;

	public LikeMethodNode(@NotNull final Modifier[] modifiers)
	{
		super(modifiers);
	}

	public void putInstructions(InstructionAdapter instructionAdapter)
	{
		instructions.addAll(instructionAdapter.getInstructions());

		maxLocals = instructionAdapter.getMaxLocals();
	}
}
