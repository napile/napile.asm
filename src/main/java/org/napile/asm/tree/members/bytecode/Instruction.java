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

import java.lang.reflect.Field;

import org.napile.asm.io.xml.InstructionNameUtil;

/**
 * @author VISTALL
 * @date 22:13/31.08.12
 */
public abstract class Instruction
{
	public abstract <T, R> R accept(InstructionVisitor<T, R> visitor, T a2);

	@Override
	public final String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(InstructionNameUtil.toXmlTag(getClass()));

		Field[] fields = getClass().getDeclaredFields();
		if(fields.length > 0)
		{
			builder.append("{");
			for(int i = 0; i < fields.length; i++)
			{
				if(i != 0)
					builder.append(", ");
				try
				{
					builder.append(fields[i].get(this));
				}
				catch(IllegalAccessException e)
				{
					//
				}
			}
			builder.append("}");
		}
		return builder.toString();
	}
}
