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

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 13:51/02.09.12
 */
public class VariableRef
{
	@NotNull
	public final FqName variable;
	@NotNull
	public final TypeNode returnType;

	public VariableRef(@NotNull FqName variable, @NotNull TypeNode returnType)
	{
		this.variable = variable;
		this.returnType = returnType;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("VariableRef");
		sb.append("{variable=").append(variable);
		sb.append(", returnType=").append(returnType);
		sb.append('}');
		return sb.toString();
	}
}
