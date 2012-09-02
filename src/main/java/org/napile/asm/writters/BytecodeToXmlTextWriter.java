package org.napile.asm.writters;

import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jetbrains.annotations.NotNull;

/**
 * @author VISTALL
 * @date 17:57/31.08.12
 */
public class BytecodeToXmlTextWriter extends BytecodeToXmlWriter<String>
{
	@NotNull
	@Override
	public String getResult()
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
