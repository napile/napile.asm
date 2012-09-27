package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 16:51/27.09.12
 */
public class JumpIfInstruction implements Instruction
{
	public final int value;

	public JumpIfInstruction(int value)
	{
		this.value = value;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitJumpIfInstruction(this, a2);
	}
}
