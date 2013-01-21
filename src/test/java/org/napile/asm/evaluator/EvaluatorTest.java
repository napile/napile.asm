package org.napile.asm.evaluator;

import org.junit.Test;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.bytecode.adapter.InstructionAdapter;
import org.napile.asm.util.evaluate.Evaluator;

/**
 * @author VISTALL
 * @date 14:51/09.12.12
 */
public class EvaluatorTest extends org.junit.Assert
{
	@Test
	public void test1()
	{
		MethodNode methodNode = MethodNode.staticConstructor();

		InstructionAdapter adapter = new InstructionAdapter();
		adapter.newInt(1);
		adapter.returnVal();
		methodNode.putInstructions(adapter);

		assertSame(new Evaluator(methodNode).testIt(), null);
	}

	@Test
	public void test2()
	{
		MethodNode methodNode = MethodNode.staticConstructor();

		InstructionAdapter adapter = new InstructionAdapter();
		adapter.putTrue();
		adapter.returnVal();
		methodNode.putInstructions(adapter);

		assertSame(new Evaluator(methodNode).testIt(), null);
	}

	@Test
	public void test3()
	{
		MethodNode methodNode = MethodNode.staticConstructor();

		InstructionAdapter adapter = new InstructionAdapter();
		adapter.visitLocalVariable("");
		adapter.localGet(0);
		adapter.returnVal();
		methodNode.putInstructions(adapter);

		assertSame(new Evaluator(methodNode).testIt(), null);
	}

	@Test
	public void test4()
	{
		MethodNode methodNode = MethodNode.staticConstructor();

		InstructionAdapter adapter = new InstructionAdapter();
		adapter.visitLocalVariable("");
		adapter.localGet(0);
		adapter.returnVal();
		methodNode.putInstructions(adapter);

		assertSame(new Evaluator(methodNode).testIt(), null);
	}

	@Test
	public void test5()
	{
		MethodNode methodNode = MethodNode.staticConstructor();

		InstructionAdapter adapter = new InstructionAdapter();
		adapter.visitLocalVariable("");
		adapter.localGet(0);
		adapter.localPut(0);
		methodNode.putInstructions(adapter);

		assertSame(new Evaluator(methodNode).testIt(), null);
	}
}
