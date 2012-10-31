package org.napile.asm.tree.members.bytecode.impl;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 10:15/31.10.12
 */
public class InvokeAnonymInstruction implements Instruction
{
	public MethodRef methodRef;

	public InvokeAnonymInstruction(@NotNull List<TypeNode> parameters, @NotNull List<TypeNode> typeArguments, @NotNull TypeNode returnType)
	{
		methodRef = new MethodRef(FqName.ROOT, parameters, typeArguments, returnType);
	}

	@NotNull
	@Override
	public <T, R> R accept(InstructionVisitor<T, R> visitor, T a2)
	{
		return visitor.visitInvokeAnonym(this, a2);
	}

	@Override
	public String toString()
	{
		return "invoke_anonym: " + methodRef;
	}
}
