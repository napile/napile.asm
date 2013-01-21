package org.napile.asm.tree.members.bytecode.impl;

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
public class Dup1x1Instruction extends Instruction
{
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitDup1x1(this, a2);
	}
}
