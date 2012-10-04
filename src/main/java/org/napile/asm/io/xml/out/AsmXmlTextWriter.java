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

package org.napile.asm.io.xml.out;

import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jetbrains.annotations.NotNull;

/**
 * @author VISTALL
 * @date 17:57/31.08.12
 */
public class AsmXmlTextWriter extends AbstractAsmXmlWriter<String>
{
	@NotNull
	@Override
	protected String getResult()
	{
		StringWriter stringWriter = new StringWriter();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent("\t");
		try
		{
			XMLWriter writer = new XMLWriter(stringWriter, format);
			writer.write(document);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return stringWriter.toString();
	}
}
