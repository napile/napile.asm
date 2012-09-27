package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:31/02.09.12
 */
public class NewDoubleInstruction implements Instruction
{
	public final double value;

	public NewDoubleInstruction(double value)
	{
		this.value = value;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitNewDouble(this, a2);
	}
}
