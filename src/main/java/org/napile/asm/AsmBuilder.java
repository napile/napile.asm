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

package org.napile.asm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.AbstractMemberNode;
import org.napile.asm.tree.members.Node;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.io.AsmWriter;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 17:39/31.08.12
 */
public class AsmBuilder
{
	private final LangVersion langVersion;

	private Deque<ClassNode> classNodes = new ArrayDeque<ClassNode>();

	private Deque<Node> lastNodes = new ArrayDeque<Node>();

	public AsmBuilder()
	{
		this(LangVersion.CURRENT);
	}

	public AsmBuilder(@NotNull LangVersion langVersion)
	{
		this.langVersion = langVersion;
	}

	//--------------------------------------------------------------------------------------------------

	public ClassNode visitClass(@NotNull Modifier[] modifiers, @NotNull FqName fqName)
	{
		ClassNode classNode = new ClassNode(modifiers, fqName);

		classNodes.add(classNode);
		lastNodes.add(classNode);

		return classNode;
	}

	public MethodNode visitMethod(@NotNull Modifier[] modifiers, @NotNull String name)
	{
		ClassNode classNode = get(ClassNode.class, false);

		MethodNode methodNode = new MethodNode(modifiers, name);

		classNode.members.add(methodNode);

		lastNodes.add(methodNode);

		return methodNode;
	}

	public VariableNode visitVariable(@NotNull Modifier[] modifiers, @NotNull String name)
	{
		ClassNode classNode = get(ClassNode.class, false);

		VariableNode variableNode = new VariableNode(modifiers, name);

		classNode.members.add(variableNode);

		lastNodes.add(variableNode);

		return variableNode;
	}

	public MethodParameterNode visitMethodParameter(boolean isFinal, @NotNull String name, @NotNull TypeNode type)
	{
		MethodNode methodNode = get(MethodNode.class, true);

		MethodParameterNode methodParameterNode = new MethodParameterNode(isFinal ? Modifier.list(Modifier.FINAL) : Modifier.EMPTY, name, type);

		methodNode.parameters.add(methodParameterNode);

		lastNodes.add(methodParameterNode);

		return methodParameterNode;
	}

	public TypeParameterNode visitTypeParameter(@NotNull String name)
	{
		AbstractMemberNode abstractMemberNode = get(AbstractMemberNode.class, true);

		TypeParameterNode typeParameterNode = abstractMemberNode.visitTypeParameter(name);

		lastNodes.add(typeParameterNode);

		return typeParameterNode;
	}

	//--------------------------------------------------------------------------------------------------
	@NotNull
	public ClassTypeNode createClassType(@NotNull String name)
	{
		return new ClassTypeNode(new FqName(name));
	}

	@NotNull
	public TypeNode createTypeOfClass(@NotNull FqName name)
	{
		return createTypeOfClass(name, false);
	}

	@NotNull
	public TypeNode createTypeOfClass(@NotNull FqName name, boolean nullable)
	{
		return new TypeNode(nullable, new ClassTypeNode(name));
	}

	@NotNull
	public TypeNode createTypeOfClass(@NotNull String name)
	{
		return createTypeOfClass(name, false);
	}

	@NotNull
	public TypeNode createTypeOfClass(@NotNull String name, boolean nullable)
	{
		return new TypeNode(nullable, createClassType(name));
	}

	//--------------------------------------------------------------------------------------------------
	@NotNull
	private <T> T get(Class<T> clazz, boolean l)
	{
		Node asmNode = l ? lastNodes.peekLast() : classNodes.peekLast();
		if(asmNode != null && clazz.isAssignableFrom(asmNode.getClass()))
			return (T) asmNode;
		else
			throw new IllegalArgumentException("no node");
	}

	@NotNull
	public <W> List<W> getResult(AsmWriter<?, ?, W> writer)
	{
		List<W> result = new ArrayList<W>(classNodes.size());
		for(ClassNode classNode : classNodes)
			result.add(writer.write(langVersion, classNode));
		return result;
	}
}
