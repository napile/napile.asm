package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.MethodRef;

/**
 * @author VISTALL
 * @date 8:48/29.11.12
 */
public abstract class InvokeInstruction extends Instruction
{
	@NotNull
	public final MethodRef methodRef;

	public boolean nullable;

	public InvokeInstruction(@NotNull MethodRef methodRef, boolean nullable)
	{
		this.methodRef = methodRef;
		this.nullable = nullable;
	}
}
