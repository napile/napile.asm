package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 19:00/04.10.12
 */
public class IsInstruction implements Instruction
{
	public final TypeNode value;

	public IsInstruction(TypeNode value)
	{
		this.value = value;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitIsInstruction(this, a2);
	}

	@Override
	public String toString()
	{
		return "is: " + value;
	}
}
