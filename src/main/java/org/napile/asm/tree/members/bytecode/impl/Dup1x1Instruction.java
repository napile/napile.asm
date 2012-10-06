package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 20:12/06.10.12
 *
 * Dup instruction it convert stack from
 * - o
 * - target
 * dupped to
 * - o
 * - target
 * - o
 */
public class Dup1x1Instruction implements Instruction
{
	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitDup1x1(this, a2);
	}

	@Override
	public String toString()
	{
		return "dup1x1";
	}
}
