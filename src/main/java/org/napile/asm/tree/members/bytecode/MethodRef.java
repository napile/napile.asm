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

package org.napile.asm.tree.members.bytecode;

import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.resolve.name.FqName;
import com.intellij.openapi.util.text.StringUtil;

/**
 * @author VISTALL
 * @date 22:17/31.08.12
 */
public class MethodRef
{
	@NotNull
	public final FqName method;
	@NotNull
	public final TypeNode returnType;
	@NotNull
	public final List<MethodParameterNode> parameters;
	@NotNull
	public final List<TypeNode> typeArguments;

	public MethodRef(@NotNull FqName method, @NotNull List<MethodParameterNode> parameters, @NotNull List<TypeNode> typeArguments, @NotNull TypeNode returnType)
	{
		this.method = method;
		this.returnType = returnType;
		this.parameters = Collections.unmodifiableList(parameters);
		this.typeArguments = Collections.unmodifiableList(typeArguments);
	}

	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("meth ");
		b.append(method.getFqName()).append(" ");
		if(!typeArguments.isEmpty())
		{
			b.append("<");
			b.append(StringUtil.join(typeArguments, ", "));
			b.append(">");
		}
		b.append("(");
		b.append(StringUtil.join(parameters, ", "));
		b.append(")");
		b.append(" : ");
		b.append(returnType);
		return b.toString();
	}
}
