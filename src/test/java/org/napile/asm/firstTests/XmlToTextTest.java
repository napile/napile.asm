package org.napile.asm.firstTests;

import org.napile.asm.LangVersion;
import org.napile.asm.io.xml.out.AsmTextTextWriter;
import org.napile.asm.tree.members.ClassNode;

/**
 * @author VISTALL
 * @date 11:41/11.10.12
 */
public class XmlToTextTest
{
	public static void main(String... arg)
	{
		ClassNode classNode = NodeUtil.createTestClassNode();

		AsmTextTextWriter writer = new AsmTextTextWriter();

		System.out.println(writer.write(LangVersion.CURRENT, classNode));
	}
}
