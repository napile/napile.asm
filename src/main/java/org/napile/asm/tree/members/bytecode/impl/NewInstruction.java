package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:21/02.09.12
 */
public class NewInstruction implements Instruction
{
	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitNew(this, a2);
	}
}
