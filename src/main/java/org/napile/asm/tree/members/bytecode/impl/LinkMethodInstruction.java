package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;

/**
 * @author VISTALL
 * @date 10:21/31.10.12
 */
public class LinkMethodInstruction implements Instruction
{
	@NotNull
	public final MethodRef methodRef;

	public LinkMethodInstruction(@NotNull MethodRef methodRef)
	{
		this.methodRef = methodRef;
	}

	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitLinkMethod(this, a2);
	}

	@Override
	public String toString()
	{
		return "link_method: " + methodRef;
	}
}
