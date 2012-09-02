package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 13:14/02.09.12
 */
public class DupInstruction implements Instruction
{
	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitDup(this, a2);
	}
}
