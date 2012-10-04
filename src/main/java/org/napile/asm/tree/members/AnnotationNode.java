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

import org.jetbrains.annotations.NotNull;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 0:25/14.08.12
 */
public class AnnotationNode implements Node
{
	private final FqName name;

	public AnnotationNode(@NotNull FqName name)
	{
		this.name = name;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitAnnotationNode(this, arg);
	}

	public FqName getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return getName().toString(); //TODO [VISTALL] arguments
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != AnnotationNode.class)
			return false;
		return toString().equals(o.toString()); //TODO [VISTALL] arguments
	}
}
