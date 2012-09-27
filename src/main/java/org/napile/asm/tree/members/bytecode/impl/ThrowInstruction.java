package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 1:10/20.09.12
 */
public class ThrowInstruction implements Instruction
{
	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitThrowInstruction(this, a2);
	}
}
