/*
 * Copyright 2010-2012 JetBrains s.r.o.
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

package org.napile.asm.tree.members.types.constructors;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.NodeVisitor;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 0:07/14.08.12
 */
public class ClassTypeNode implements TypeConstructorNode
{
	@NotNull
	public final FqName className;

	public ClassTypeNode(@NotNull FqName className)
	{
		this.className = className;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T a2)
	{
		return visitor.visitClassTypeNode(this, a2);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != ClassTypeNode.class)
			return false;

		return className.toString().equals(o.toString());
	}

	@Override
	public String toString()
	{
		return className.toString();
	}
}
