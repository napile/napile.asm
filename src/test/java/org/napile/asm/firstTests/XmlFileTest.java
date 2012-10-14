package org.napile.asm.firstTests;

import java.io.File;

import org.napile.asm.LangVersion;
import org.napile.asm.io.xml.out.AsmXmlFileWriter;
import org.napile.asm.tree.members.ClassNode;

/**
 * @author VISTALL
 * @date 18:57/04.09.12
 */
public class XmlFileTest
{
	public static void main(String... arg)
	{
		ClassNode classNode = NodeUtil.createTestClassNode();

		AsmXmlFileWriter writer = new AsmXmlFileWriter(new File("src/test/output"));

		System.out.println(writer.write(LangVersion.CURRENT, classNode));
	}
}
