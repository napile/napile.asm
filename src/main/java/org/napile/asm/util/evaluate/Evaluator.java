package org.napile.asm.util.evaluate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.napile.asm.tree.members.CodeInfo;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.bytecode.Instruction;

/**
 * @author VISTALL
 * @date 14:25/09.12.12
 */
public class Evaluator
{
	public final int locals;
	private final List<Instruction> instructions;

	private EvaluatorInstructionVisitor visitor;

	public Evaluator(MethodNode methodNode)
	{
		this(methodNode.code);
	}

	public Evaluator(CodeInfo codeInfo)
	{
		locals = codeInfo == null ? 0 : codeInfo.maxLocals;
		instructions = codeInfo == null ? Collections.<Instruction>emptyList() : new ArrayList<Instruction>(codeInfo.instructions);

		visitor = new EvaluatorInstructionVisitor(this);
	}

	public String testIt()
	{
		for(int i = 0; i < instructions.size(); i++)
		{
			Instruction instruction = instructions.get(i);
			instruction.accept(visitor, i);
		}
		return null;
	}
}
