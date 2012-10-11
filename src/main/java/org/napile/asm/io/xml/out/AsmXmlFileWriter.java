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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jetbrains.annotations.NotNull;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 18:51/04.09.12
 */
public class AsmXmlFileWriter extends AbstractAsmXmlWriter<File>
{
	public static final String DOT_EXTENSION = ".nxml";

	@NotNull
	private final File outputDir;

	public AsmXmlFileWriter(@NotNull File outputDir)
	{
		this.outputDir = outputDir;
	}

	@NotNull
	@Override
	protected File getResult()
	{
		File file = null;
		List<FqName> paths = fqName.path();
		for(int i = 0; i < paths.size(); i++)
		{
			FqName path = paths.get(i);
			file = new File(outputDir, path.getFqName().replace(".", File.separator));

			// last segment is original FqName
			if(i != paths.size() - 1)
				file.mkdirs();
		}

		assert file != null;

		file = new File(file.getAbsolutePath() + DOT_EXTENSION);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent("\t");
		try
		{
			XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
			writer.write(document);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return file;
	}
}
