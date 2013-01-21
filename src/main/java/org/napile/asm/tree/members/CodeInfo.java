/*
 * Copyright 2010-2013 napile.org
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
import java.util.Collection;
import java.util.Collections;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.adapter.InstructionAdapter;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;

/**
 * @author VISTALL
 * @date 18:26/19.01.13
 */
public class CodeInfo
{
	@NotNull
	public final Collection<Instruction> instructions;

	@NotNull
	public final Collection<TryCatchBlockNode> tryCatchBlockNodes;

	public int maxLocals;

	public CodeInfo()
	{
		instructions = new ArrayList<Instruction>();
		tryCatchBlockNodes = new ArrayList<TryCatchBlockNode>(0);
	}

	public CodeInfo(InstructionAdapter instructionAdapter)
	{
		instructions = Collections.unmodifiableCollection(instructionAdapter.getInstructions());
		tryCatchBlockNodes = Collections.unmodifiableCollection(instructionAdapter.getTryCatchBlockNodes());

		maxLocals = instructionAdapter.getMaxLocals();
	}
}
