/*
 * Copyright 2010-2013 napile.org
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

package org.napile.asm.io.xml;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.bytecode.Instruction;

/**
 * @author VISTALL
 * @date 16:39/17.01.13
 */
public class InstructionNameUtil
{
	private static Map<Class<?>, String> CACHE = new HashMap<Class<?>, String>();

	public static Class<? extends Instruction> fromXmlTag(String name)
	{
		StringBuilder builder = new StringBuilder();
		char[] datas = name.toCharArray();
		for(int i = 0; i < datas.length; i++)
		{
			char a = datas[i];
			if(i == 0)
				builder.append(Character.toUpperCase(datas[i]));
			else if(a == '-')
				builder.append(Character.toUpperCase(datas[++ i]));
			else
				builder.append(a);
		}
		builder.append("Instruction");
		try
		{
			return (Class<? extends Instruction>) Class.forName("org.napile.asm.tree.members.bytecode.impl." + builder.toString());
		}
		catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	@NotNull
	public static String toXmlTag(Class<? extends Instruction> clazz)
	{
		String name = null;
		if((name = CACHE.get(clazz)) != null)
			return name;

		name = clazz.getSimpleName();
		if(!name.endsWith("Instruction"))
			throw new IllegalArgumentException("Instruction class need endsWith 'Instruction'");
		name = name.substring(0, name.length() - 11);

		StringBuilder builder = new StringBuilder();
		char[] datas = name.toCharArray();
		for(int i = 0; i < datas.length; i++)
		{
			char a = datas[i];
			if(Character.isUpperCase(a))
			{
				// dont place it at start
				if(i != 0)
					builder.append("-");
				builder.append(Character.toLowerCase(a));
			}
			else
				builder.append(a);
		}
		name = builder.toString();
		CACHE.put(clazz, name);
		return name;
	}
}
