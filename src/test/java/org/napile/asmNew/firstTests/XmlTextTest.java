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

package org.napile.asmNew.firstTests;

import java.util.List;

import org.napile.asm.AsmBuilder;
import org.napile.asm.writters.BytecodeToXmlTextWriter;

/**
 * @author VISTALL
 * @date 22:46/13.08.12
 */
public class XmlTextTest
{
	public static void main(String... arg)
	{
		AsmBuilder builder = NodeUtil.createTestClassNode();

		List<String> result = builder.getResult(new BytecodeToXmlTextWriter());

		for(String s : result)
			System.out.println(s);
	}
}
