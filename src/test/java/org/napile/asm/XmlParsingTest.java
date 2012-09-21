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

package org.napile.asm;

import java.io.FileInputStream;

import org.napile.asm.io.xml.in.AsmXmlFileReader;
import org.napile.asm.tree.members.ClassNode;

/**
 * @author VISTALL
 * @date 17:16/21.09.12
 */
public class XmlParsingTest
{
	public static void main(String... arg) throws Exception
	{
		AsmXmlFileReader xmlFileReader = new AsmXmlFileReader();

		ClassNode classNode = xmlFileReader.read(new FileInputStream("src/test/output/napile/lang/Int.xml"));

		System.out.println(classNode);
	}
}
