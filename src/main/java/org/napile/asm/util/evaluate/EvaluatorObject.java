package org.napile.asm.util.evaluate;

import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 14:29/09.12.12
 */
public class EvaluatorObject
{
	private final int createdIndex;
	private final Instruction createdBy;
	private final TypeNode type;

	public EvaluatorObject(int createdIndex, Instruction createdBy, TypeNode type)
	{
		this.createdIndex = createdIndex;
		this.createdBy = createdBy;
		this.type = type;
	}
}
