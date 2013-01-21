package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 19:00/04.10.12
 */
public class IsInstruction extends Instruction
{
	public final TypeNode value;

	public IsInstruction(TypeNode value)
	{
		this.value = value;
	}

	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitIs(this, a2);
	}
}
