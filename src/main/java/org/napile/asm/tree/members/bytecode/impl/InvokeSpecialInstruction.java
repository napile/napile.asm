package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;

/**
 * @author VISTALL
 * @date 13:43/02.09.12
 */
public class InvokeSpecialInstruction implements Instruction
{
	@NotNull
	public final MethodRef methodRef;

	public InvokeSpecialInstruction(@NotNull MethodRef methodRef)
	{
		this.methodRef = methodRef;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitInvokeSpecial(this, a2);
	}
}
