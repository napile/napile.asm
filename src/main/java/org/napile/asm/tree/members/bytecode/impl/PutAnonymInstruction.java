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

package org.napile.asm.tree.members.bytecode.impl;

import java.util.Collections;
import java.util.List;

import org.napile.asm.tree.members.CodeInfo;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.util.IntIntPair;

/**
 * @author VISTALL
 * @date 18:16/19.01.13
 */
public class PutAnonymInstruction extends Instruction
{
	public final List<IntIntPair> require;

	public final CodeInfo code;

	public PutAnonymInstruction(List<IntIntPair> require, CodeInfo code)
	{
		this.require = Collections.unmodifiableList(require);
		this.code = code;
	}

	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitPutAnonym(this, a2);
	}
}
