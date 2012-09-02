package org.napile.asm.tree.members.bytecode.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.VariableRef;

/**
 * @author VISTALL
 * @date 13:50/02.09.12
 */
public class PutToStaticVariableInstruction implements Instruction
{
	@NotNull
	public final VariableRef variableRef;

	public PutToStaticVariableInstruction(@NotNull VariableRef variableRef)
	{
		this.variableRef = variableRef;
	}

	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitPutToStaticVariable(this, a2);
	}
}
