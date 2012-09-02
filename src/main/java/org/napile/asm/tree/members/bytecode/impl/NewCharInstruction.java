package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:28/02.09.12
 */
public class NewCharInstruction implements Instruction
{
	public final char value;

	public NewCharInstruction(char value)
	{
		this.value = value;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitNewChar(this, a2);
	}
}
