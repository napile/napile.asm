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
import org.napile.java2napile.runtime.vm.ToNapileClass;

/**
 * @author VISTALL
 * @date 0:25/14.08.12
 */
@ToNapileClass("napile.asm.members.AsmAnnotation")
public class AnnotationNode implements Node
{
	public final CodeInfo code;
	public final String[] parameters;

	public AnnotationNode(CodeInfo code, String[] parameters)
	{
		this.code = code;
		this.parameters = parameters;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitAnnotationNode(this, arg);
	}
}
