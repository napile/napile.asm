package org.napile.asm.util.evaluate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.AsmConstants;
import org.napile.asm.lib.NapileReflectPackage;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.impl.*;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;

/**
 * @author VISTALL
 * @date 14:26/09.12.12
 */
public class EvaluatorInstructionVisitor implements InstructionVisitor<Integer, Void>
{
	private final Deque<EvaluatorObject> stack = new ArrayDeque<EvaluatorObject>();
	private final Evaluator evaluator;

	public EvaluatorInstructionVisitor(Evaluator evaluator)
	{
		this.evaluator = evaluator;
	}

	@Override
	public Void visitDup(DupInstruction instruction, Integer index)
	{
		List<EvaluatorObject> pop = pop(1, instruction);
		push(pop.get(0));
		push(pop.get(0));
		return null;
	}

	@Override
	public Void visitLoad(LoadInstruction instruction, Integer index)
	{
		if(instruction.varIndex >= evaluator.locals)
			throw new EvaluatorException("Wrong local index (" + instruction.varIndex + ") max (" + evaluator.locals + ") instruction: " + instruction + ". Method: " + evaluator.methodNode);

		push(new EvaluatorObject(index, instruction, AsmConstants.ANY_TYPE));
		return null;
	}

	@Override
	public Void visitStore(StoreInstruction instruction, Integer index)
	{
		if(instruction.varIndex >= evaluator.locals)
			throw new EvaluatorException("Wrong local index (" + instruction.varIndex + ") max (" + evaluator.locals + ") instruction: " + instruction + ". Method: " + evaluator.methodNode);

		pop(1, instruction);
		return null;
	}

	@Override
	public Void visitNewObject(NewObjectInstruction instruction, Integer index)
	{
		pop(instruction.parameters.size(), instruction);

		push(new EvaluatorObject(index, instruction, instruction.value));
		return null;
	}

	@Override
	public Void visitNewByte(NewByteInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.BYTE_TYPE));
		return null;
	}

	@Override
	public Void visitNewShort(NewShortInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.SHORT_TYPE));
		return null;
	}

	@Override
	public Void visitNewInt(NewIntInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.INT_TYPE));
		return null;
	}

	@Override
	public Void visitNewLong(NewLongInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.LONG_TYPE));
		return null;
	}

	@Override
	public Void visitNewFloat(NewFloatInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.FLOAT_TYPE));
		return null;
	}

	@Override
	public Void visitNewDouble(NewDoubleInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.DOUBLE_TYPE));
		return null;
	}

	@Override
	public Void visitNewChar(NewCharInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.CHAR_TYPE));
		return null;
	}

	@Override
	public Void visitNewString(NewStringInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.STRING_TYPE));
		return null;
	}

	@Override
	public Void visitReturn(ReturnInstruction instruction, Integer index)
	{
		pop(1, instruction);
		return null;
	}

	@Override
	public Void visitInvokeStatic(InvokeStaticInstruction instruction, Integer index)
	{
		pop(instruction.methodRef.parameters.size(), instruction);

		push(new EvaluatorObject(index, instruction, instruction.methodRef.returnType));
		return null;
	}

	@Override
	public Void visitInvokeSpecial(InvokeSpecialInstruction instruction, Integer index)
	{
		pop(instruction.methodRef.parameters.size() + 1, instruction);

		push(new EvaluatorObject(index, instruction, instruction.methodRef.returnType));

		return null;
	}

	@Override
	public Void visitInvokeVirtual(InvokeVirtualInstruction instruction, Integer index)
	{
		pop(instruction.methodRef.parameters.size() + 1, instruction);

		push(new EvaluatorObject(index, instruction, instruction.methodRef.returnType));

		return null;
	}

	@Override
	public Void visitMacroStaticJump(MacroStaticJumpInstruction instruction, Integer index)
	{
		return null;
	}

	@Override
	public Void visitMacroJump(MacroJumpInstruction instruction, Integer index)
	{
		return null;
	}

	@Override
	public Void visitInvokeAnonym(InvokeAnonymInstruction instruction, Integer index)
	{
		pop(instruction.methodRef.parameters.size(), instruction);

		push(new EvaluatorObject(index, instruction, instruction.methodRef.returnType));

		return null;
	}

	@Override
	public Void visitPutToVariable(PutToVariableInstruction instruction, Integer index)
	{
		pop(2, instruction);
		return null;
	}

	@Override
	public Void visitPutToStaticVariable(PutToStaticVariableInstruction instruction, Integer index)
	{
		pop(1, instruction);
		return null;
	}

	@Override
	public Void visitGetVariable(GetVariableInstruction instruction, Integer index)
	{
		pop(1, instruction);
		push(new EvaluatorObject(index, instruction, instruction.variableRef.returnType));
		return null;
	}

	@Override
	public Void visitGetStaticVariable(GetStaticVariableInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, instruction.variableRef.returnType));
		return null;
	}

	@Override
	public Void visitThrow(ThrowInstruction throwInstruction, Integer index2)
	{
		pop(1, throwInstruction);
		return null;
	}

	@Override
	public Void visitSwap(SwapInstruction swapInstruction, Integer index2)
	{
		List<EvaluatorObject> instructions = pop(2, swapInstruction);
		push(instructions.get(1));
		push(instructions.get(0));
		return null;
	}

	@Override
	public Void visitPop(PopInstruction popInstruction, Integer index2)
	{
		pop(1, popInstruction);
		return null;
	}

	@Override
	public Void visitJumpIf(JumpIfInstruction jumpIfInstruction, Integer index2)
	{
		pop(2, jumpIfInstruction);
		return null;
	}

	@Override
	public Void visitJump(JumpInstruction jumpInstruction, Integer index2)
	{
		return null;
	}

	@Override
	public Void visitTypeOf(TypeOfInstruction typeOfInstruction, Integer index)
	{
		push(new EvaluatorObject(index, typeOfInstruction, new TypeNode(false, new ClassTypeNode(NapileReflectPackage.TYPE)).visitArgument(typeOfInstruction.value)));
		return null;
	}

	@Override
	public Void visitClassOf(ClassOfInstruction classOfInstruction, Integer index)
	{
		push(new EvaluatorObject(index, classOfInstruction, new TypeNode(false, new ClassTypeNode(NapileReflectPackage.CLASS)).visitArgument(classOfInstruction.value)));
		return null;
	}

	@Override
	public Void visitIs(IsInstruction isInstruction, Integer index)
	{
		pop(1, isInstruction);

		push(new EvaluatorObject(index, isInstruction, AsmConstants.BOOL_TYPE));
		return null;
	}

	@Override
	public Void visitDup1x1(Dup1x1Instruction instruction, Integer index2)
	{
		List<EvaluatorObject> pop = pop(2, instruction);
		push(pop.get(0));
		push(pop.get(1));
		push(pop.get(0));
		return null;
	}

	@Override
	public Void visitLinkMethod(LinkMethodInstruction instruction, Integer index)
	{
		pop(1, instruction);

		push(new EvaluatorObject(index, instruction, AsmConstants.METHOD_LINK_TYPE));
		return null;
	}

	@Override
	public Void visitLinkStaticMethod(LinkStaticMethodInstruction instruction, Integer index)
	{
		push(new EvaluatorObject(index, instruction, AsmConstants.METHOD_LINK_TYPE));
		return null;
	}

	private void push(EvaluatorObject e)
	{
		stack.add(e);
	}

	@NotNull
	private List<EvaluatorObject> pop(int size, Instruction instruction)
	{
		if(size == 0)
			return Collections.emptyList();
		if(stack.size() < size)
			throw new EvaluatorException("Require (" + size +  ") objects but found (" + stack.size() + ") for instruction: " + instruction + ". Method: " + evaluator.methodNode);

		List<EvaluatorObject> objects = new ArrayList<EvaluatorObject>(size);
		for(int i = 0; i < size; i++)
			objects.add(stack.pollLast());
		Collections.reverse(objects);
		return objects;
	}
}
