package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:30/02.09.12
 */
public class NewFloatInstruction implements Instruction
{
	public final float value;

	public NewFloatInstruction(float value)
	{
		this.value = value;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitNewFloat(this, a2);
	}
}
