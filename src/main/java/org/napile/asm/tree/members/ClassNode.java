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
import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.LangVersion;
import org.napile.asm.Modifier;
import org.napile.asm.io.xml.out.AsmXmlTextWriter;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.tree.MemberAddListener;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.util.evaluate.MethodEvaluatorListener;

/**
 * A node that represents a class.
 *
 * @author VISTALL
 *
 * base idea was get from ObjectWeb Asm
 */
public class ClassNode extends AbstractMemberNode<ClassNode>
{
	public final FqName name;

	@NotNull
	private List<AbstractMemberNode> members = new ArrayList<AbstractMemberNode>();

	@NotNull
	public final List<TypeNode> supers = new ArrayList<TypeNode>(1);

	@NotNull
	public final List<MemberAddListener> listeners = new ArrayList<MemberAddListener>(Arrays.asList(new MethodEvaluatorListener()));

	public ClassNode(@NotNull Modifier[] modifiers, @NotNull FqName fqName)
	{
		super(modifiers);

		this.name = fqName;
	}

	public void addMember(@NotNull AbstractMemberNode<?> memberNode)
	{
		members.add(memberNode);

		memberNode.parent = this;

		for(MemberAddListener memberAddListener : listeners)
			memberAddListener.onMemberAdd(this, memberNode);
	}

	@NotNull
	public List<AbstractMemberNode> getMembers()
	{
		return members;
	}

	public ClassNode visitSuper(@NotNull TypeNode typeNode)
	{
		if(typeNode.nullable || !(typeNode.typeConstructorNode instanceof ClassTypeNode))
			throw new IllegalArgumentException("Super type cant be nullable or not ClassTypeNode");
		supers.add(typeNode);
		return this;
	}

	// ------------------------------------------------------------------------
	// Accept method
	// ------------------------------------------------------------------------

	@Override
	public <T, R> R accept(@org.jetbrains.annotations.NotNull final NodeVisitor<T, R> asmVisitor, T a2)
	{
		return asmVisitor.visitClassNode(this, a2);
	}

	@Override
	public String toString()
	{
		AsmXmlTextWriter writer = new AsmXmlTextWriter();
		return writer.write(LangVersion.CURRENT, this);
	}
}
