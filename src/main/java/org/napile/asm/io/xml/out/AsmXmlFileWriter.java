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

		file = new File(file.getAbsolutePath() + ".xml");

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
