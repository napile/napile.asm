package org.napile.asm.tree.members.bytecode.impl;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;

/**
 * @author VISTALL
 * @date 14:59/20.09.12
 */
public class SwapInstruction implements Instruction
{
	@Override
	public <T> void accept(InstructionVisitor<T> visitor, T a2)
	{
		visitor.visitSwapInstruction(this, a2);
	}
}
