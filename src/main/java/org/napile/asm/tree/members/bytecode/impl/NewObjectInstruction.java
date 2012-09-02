package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 13:21/02.09.12
 */
public class NewObjectInstruction implements Instruction
{
	@NotNull
	public final TypeNode value;

	public NewObjectInstruction(@NotNull TypeNode value)
	{
		this.value = value;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitNewObject(this, a2);
	}
}
