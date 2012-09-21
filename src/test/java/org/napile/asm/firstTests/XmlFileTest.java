package org.napile.asm.firstTests;

import java.io.File;
import java.util.List;

import org.napile.asm.AsmBuilder;
import org.napile.asm.io.xml.out.AsmXmlFileWriter;

/**
 * @author VISTALL
 * @date 18:57/04.09.12
 */
public class XmlFileTest
{
	public static void main(String... arg)
	{
		AsmBuilder builder = NodeUtil.createTestClassNode();

		List<File> result = builder.getResult(new AsmXmlFileWriter(new File("src/test/output")));

		for(File s : result)
			System.out.println(s.getAbsolutePath());
	}
}
