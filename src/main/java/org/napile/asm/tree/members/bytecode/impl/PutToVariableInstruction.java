package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.VariableRef;

/**
 * @author VISTALL
 * @date 13:50/02.09.12
 */
public class PutToVariableInstruction implements Instruction
{
	@NotNull
	public final VariableRef variableRef;

	public PutToVariableInstruction(@NotNull VariableRef variableRef)
	{
		this.variableRef = variableRef;
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitPutToVariable(this, a2);
	}
}
