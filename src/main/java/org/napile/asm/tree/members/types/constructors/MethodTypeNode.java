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

package org.napile.asm.tree.members.types.constructors;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.NodeVisitor;
import org.napile.asm.tree.members.types.TypeNode;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.Function;

/**
 * @author VISTALL
 * @date 12:06/14.10.12
 */
public class MethodTypeNode implements TypeConstructorNode
{
	@NotNull
	public TypeNode returnType = AsmConstants.NULL_TYPE;

	@NotNull
	public final List<MethodParameterNode> parameters = new ArrayList<MethodParameterNode>(0);

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitMethodTypeNode(this, arg);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != MethodTypeNode.class)
			return false;

		MethodTypeNode oType = (MethodTypeNode) o;
		if(!returnType.equals(oType.returnType))
			return false;

		return Comparing.equal(parameters, oType.parameters);
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("{(");
		b.append(StringUtil.join(parameters, new Function<MethodParameterNode, String>()
		{
			@Override
			public String fun(MethodParameterNode methodParameterNode)
			{
				StringBuilder b = new StringBuilder();
				if(ArrayUtil.contains(Modifier.MUTABLE, methodParameterNode.modifiers))
					b.append("var ");
				else
					b.append("val ");
				b.append(methodParameterNode.name).append(" : ").append(methodParameterNode.returnType);
				return b.toString();
			}
		}, ", "));

		b.append(") : ");
		b.append(returnType);
		b.append("}");
		return b.toString();
	}
}
