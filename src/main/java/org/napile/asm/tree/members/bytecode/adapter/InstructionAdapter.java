/*
 * Copyright 2010-2012 napile.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.napile.asm.tree.members.bytecode.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.AsmConstants;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.bytecode.VariableRef;
import org.napile.asm.tree.members.bytecode.impl.*;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 20:25/17.09.12
 */
public class InstructionAdapter implements Iterable<Instruction>
{
	private static final MethodRef BOOL_TRUE = new MethodRef(NapileLangPackage.BOOL.child(Name.identifier("TRUE$get")), Collections.<TypeNode>emptyList(), Collections.<TypeNode>emptyList(), AsmConstants.BOOL_TYPE);

	private static final MethodRef BOOL_FALSE = new MethodRef(NapileLangPackage.BOOL.child(Name.identifier("FALSE$get")), Collections.<TypeNode>emptyList(), Collections.<TypeNode>emptyList(), AsmConstants.BOOL_TYPE);

	private static final MethodRef NULL = new MethodRef(NapileLangPackage.NULL.child(Name.identifier("INSTANCE$get")), Collections.<TypeNode>emptyList(), Collections.<TypeNode>emptyList(), AsmConstants.NULL_TYPE);

	@NotNull
	private final List<Instruction> instructions = new ArrayList<Instruction>();

	@NotNull
	private final List<TryCatchBlockNode> tryCatchBlockNodes = new ArrayList<TryCatchBlockNode>();

	private int maxLocals;

	public InstructionAdapter()
	{
	}

	@NotNull
	public LoadInstruction load(int index)
	{
		return add(new LoadInstruction(index));
	}

	@NotNull
	public StoreInstruction store(int index)
	{
		return add(new StoreInstruction(index));
	}

	@NotNull
	public NewIntInstruction newInt(int value)
	{
		return add(new NewIntInstruction(value));
	}

	@NotNull
	public NewStringInstruction newString(@NotNull String value)
	{
		return add(new NewStringInstruction(value));
	}

	@NotNull
	public InvokeSpecialInstruction invokeSpecial(MethodRef methodRef)
	{
		return add(new InvokeSpecialInstruction(methodRef));
	}

	@NotNull
	public InvokeStaticInstruction invokeStatic(MethodRef methodRef)
	{
		return add(new InvokeStaticInstruction(methodRef));
	}

	@NotNull
	public InvokeVirtualInstruction invokeVirtual(MethodRef methodRef)
	{
		return add(new InvokeVirtualInstruction(methodRef));
	}

	@NotNull
	public PutToVariableInstruction putToVar(VariableRef variableRef)
	{
		return add(new PutToVariableInstruction(variableRef));
	}

	@NotNull
	public PutToStaticVariableInstruction putToStaticVar(VariableRef variableRef)
	{
		return add(new PutToStaticVariableInstruction(variableRef));
	}

	@NotNull
	public GetVariableInstruction getVar(VariableRef variableRef)
	{
		return add(new GetVariableInstruction(variableRef));
	}

	@NotNull
	public GetStaticVariableInstruction getStaticVar(VariableRef variableRef)
	{
		return add(new GetStaticVariableInstruction(variableRef));
	}

	@NotNull
	public NewObjectInstruction newObject(@NotNull TypeNode typeNode, @NotNull List<TypeNode> parameters)
	{
		return add(new NewObjectInstruction(typeNode, parameters));
	}

	@NotNull
	public ReturnInstruction returnVal()
	{
		return add(new ReturnInstruction());
	}

	@NotNull
	public SwapInstruction swap()
	{
		return add(new SwapInstruction());
	}

	@NotNull
	public PopInstruction pop()
	{
		return add(new PopInstruction());
	}

	@NotNull
	public DupInstruction dup()
	{
		return add(new DupInstruction());
	}

	@NotNull
	public Dup1x1Instruction dup1x1()
	{
		return add(new Dup1x1Instruction());
	}

	@NotNull
	public ThrowInstruction throwVal()
	{
		return add(new ThrowInstruction());
	}

	@NotNull
	public JumpIfInstruction jumpIf(int val)
	{
		return add(new JumpIfInstruction(val));
	}

	@NotNull
	public JumpInstruction jump(int val)
	{
		return add(new JumpInstruction(val));
	}

	@NotNull
	public ClassOfInstruction classOf(TypeNode typeNode)
	{
		return add(new ClassOfInstruction(typeNode));
	}

	@NotNull
	public TypeOfInstruction typeOf(TypeNode typeNode)
	{
		return add(new TypeOfInstruction(typeNode));
	}

	@NotNull
	public IsInstruction is(TypeNode typeNode)
	{
		return add(new IsInstruction(typeNode));
	}

	@NotNull
	public ReservedInstruction reserve()
	{
		return add(new ReservedInstruction());
	}

	public InvokeStaticInstruction putTrue()
	{
		return add(new InvokeStaticInstruction(BOOL_TRUE));
	}

	public InvokeStaticInstruction putFalse()
	{
		return add(new InvokeStaticInstruction(BOOL_FALSE));
	}

	public InvokeStaticInstruction putNull()
	{
		return add(new InvokeStaticInstruction(NULL));
	}

	public void tryCatch(@NotNull TryCatchBlockNode b)
	{
		tryCatchBlockNodes.add(b);
	}

	public int size()
	{
		return instructions.size();
	}

	public void replace(@NotNull Instruction instruction1, @NotNull Instruction instruction2)
	{
		int i = instructions.indexOf(instruction1);
		if(i < 0)
			throw new IndexOutOfBoundsException();

		instructions.set(i, instruction2);
	}

	private <T extends Instruction> T add(T t)
	{
		instructions.add(t);
		return t;
	}

	public void visitLocalVariable(String name)
	{
		maxLocals++;
	}

	@NotNull
	public Collection<Instruction> getInstructions()
	{
		return instructions;
	}

	@Override
	@NotNull
	public Iterator<Instruction> iterator()
	{
		return instructions.iterator();
	}

	public int getMaxLocals()
	{
		return maxLocals;
	}

	@NotNull
	public Collection<TryCatchBlockNode> getTryCatchBlockNodes()
	{
		return tryCatchBlockNodes;
	}
}
