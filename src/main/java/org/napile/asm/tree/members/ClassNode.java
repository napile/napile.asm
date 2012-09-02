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
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.Modifier;
import org.napile.compiler.lang.resolve.name.FqName;

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
	public List<AbstractMemberNode> members = new ArrayList<AbstractMemberNode>();

	@NotNull
	public final List<ClassTypeNode> supers = new ArrayList<ClassTypeNode>(1);

	public ClassNode(@NotNull Modifier[] modifiers, @NotNull FqName fqName)
	{
		super(modifiers);

		this.name = fqName;
	}

	public ClassNode visitSuper(@NotNull String s)
	{
		return visitSuper(new ClassTypeNode(new FqName(s)));
	}

	public ClassNode visitSuper(@NotNull FqName fqName)
	{
		return visitSuper(new ClassTypeNode(fqName));
	}

	public ClassNode visitSuper(@NotNull ClassTypeNode typeNode)
	{
		supers.add(typeNode);
		return this;
	}

	// ------------------------------------------------------------------------
	// Accept method
	// ------------------------------------------------------------------------

	@Override
	public <T> void accept(@org.jetbrains.annotations.NotNull final NodeVisitor<T> asmVisitor, T a2)
	{
		asmVisitor.visitClassNode(this, a2);
	}
}
