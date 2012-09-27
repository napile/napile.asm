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

package org.napile.asm.tree.members.types;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.AnnotableNode;
import org.napile.asm.tree.members.AnnotationNode;
import org.napile.asm.tree.members.NodeVisitor;
import org.napile.asm.tree.members.types.constructors.TypeConstructorNode;
import org.napile.asm.util.Comparing2;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Function;

/**
 * @author VISTALL
 * @date 0:18/14.08.12
 */
public class TypeNode extends AnnotableNode<TypeNode>
{
	public final boolean nullable;
	@NotNull
	public final TypeConstructorNode typeConstructorNode;

	public List<TypeNode> arguments = new ArrayList<TypeNode>(0);

	public TypeNode(boolean nullable, @NotNull TypeConstructorNode typeConstructorNode)
	{
		this.nullable = nullable;
		this.typeConstructorNode = typeConstructorNode;
	}

	@NotNull
	public TypeNode visitArgument(@NotNull TypeNode typeNode)
	{
		arguments.add(typeNode);
		return this;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitTypeNode(this, arg);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != TypeNode.class)
			return false;

		TypeNode typeNode = (TypeNode) o;

		if(!Comparing2.equal(typeNode.annotations, annotations))
			return false;

		if(!typeNode.typeConstructorNode.equals(typeConstructorNode))
			return false;

		if(!Comparing2.equal(typeNode.annotations, annotations))
			return false;

		return typeNode.nullable == nullable;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if(annotations.size() > 0)
		{
			builder.append("[");
			builder.append(StringUtil.join(annotations, new Function<AnnotationNode, String>()
			{
				@Override
				public String fun(AnnotationNode annotationNode)
				{
					return annotationNode.toString();
				}
			}, ", "));
			builder.append("]");
		}

		builder.append(typeConstructorNode.toString());

		if(arguments.size() > 0)
		{
			builder.append("<");
			builder.append(StringUtil.join(arguments, new Function<TypeNode, String>()
			{
				@Override
				public String fun(TypeNode typeNode)
				{
					return typeNode.toString();
				}
			}, ", "));
			builder.append(">");
		}

		if(nullable)
			builder.append("?");
		return builder.toString();
	}
}
