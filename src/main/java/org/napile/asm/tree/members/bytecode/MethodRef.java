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
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.compiler.lang.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 22:17/31.08.12
 */
public class MethodRef
{
	public final FqName method;
	public final TypeNode returnType;
	public final List<TypeNode> parameters;

	public MethodRef(@NotNull FqName method, @NotNull List<TypeNode> parameters, TypeNode returnType)
	{
		this.method = method;
		this.returnType = returnType;
		this.parameters = Collections.unmodifiableList(parameters);
	}
}
