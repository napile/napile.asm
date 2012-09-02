package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:25/02.09.12
 */
public class NewShortInstruction implements Instruction
{
	public final short value;

	public NewShortInstruction(short value)
	{
		this.value = value;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitNewShort(this, a2);
	}
}
