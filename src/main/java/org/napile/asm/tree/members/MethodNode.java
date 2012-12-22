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

package org.napile.asm.tree.members;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.adapter.InstructionAdapter;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 18:21/06.09.12
 */
public class MethodNode extends AbstractMemberNode<MethodNode>
{
	public static final Name CONSTRUCTOR_NAME = Name.identifier("this");
	public static final Name STATIC_CONSTRUCTOR_NAME = Name.identifier("static");

	public static MethodNode constructor(@NotNull Modifier... modifiers)
	{
		return new MethodNode(modifiers, CONSTRUCTOR_NAME);
	}

	public static MethodNode staticConstructor()
	{
		return new MethodNode(new Modifier[]{Modifier.STATIC}, STATIC_CONSTRUCTOR_NAME);
	}

	/**
	 * The method's name.
	 */
	public final Name name;
	/**
	 * Return type of method
	 */
	@NotNull
	public TypeNode returnType = AsmConstants.NULL_TYPE;

	/**
	 * Parameters of method
	 */
	@NotNull
	public final List<MethodParameterNode> parameters = new ArrayList<MethodParameterNode>(0);
	/**
	 * Code instruction
	 */
	@NotNull
	public final List<Instruction> instructions = new ArrayList<Instruction>(0);

	@NotNull
	public final List<TryCatchBlockNode> tryCatchBlockNodes = new ArrayList<TryCatchBlockNode>(0);

	/**
	 * The maximum number of local variables of this method.
	 */
	public int maxLocals;

	public MethodNode(@NotNull final Modifier[] modifiers, @NotNull Name name)
	{
		super(modifiers);
		this.name = name;
	}

	public void putInstructions(InstructionAdapter instructionAdapter)
	{
		instructions.addAll(instructionAdapter.getInstructions());

		maxLocals = instructionAdapter.getMaxLocals();
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitMethodNode(this, arg);
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append(getClass().getSimpleName()).append(":");
		if(parent != null)
			b.append(parent.name);
		b.append(".").append(name);
		return b.toString();
	}
}
