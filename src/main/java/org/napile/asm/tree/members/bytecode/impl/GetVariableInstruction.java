package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.VariableRef;

/**
 * @author VISTALL
 * @date 22:50/07.09.12
 */
public class GetVariableInstruction implements Instruction
{
	@NotNull
	public final VariableRef variableRef;

	public GetVariableInstruction(@NotNull VariableRef variableRef)
	{
		this.variableRef = variableRef;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitGetVariable(this, a2);
	}
}
