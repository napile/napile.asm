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
