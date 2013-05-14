package org.napile.asm.util.evaluate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.napile.asm.Modifier;
import org.napile.asm.tree.members.CodeInfo;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.bytecode.Instruction;
import com.intellij.util.ArrayUtil;

/**
 * @author VISTALL
 * @date 14:25/09.12.12
 */
public class Evaluator
{
	public final int locals;
	private final List<Instruction> instructions;

	private EvaluatorInstructionVisitor visitor;

	public int returnObjectCount;

	public Evaluator(VariableNode variableNode)
	{
		this(variableNode.code);
	}

	public Evaluator(MethodNode methodNode)
	{
		this(methodNode.code);

		for(MethodParameterNode parameterNode : methodNode.parameters)
		{
			if(ArrayUtil.contains(Modifier.REF, parameterNode.modifiers))
			{
				returnObjectCount ++;
			}
		}
	}

	public Evaluator(CodeInfo codeInfo)
	{
		returnObjectCount = 1;
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
