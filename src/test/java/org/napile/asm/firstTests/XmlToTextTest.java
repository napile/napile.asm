package org.napile.asm.firstTests;

import java.util.List;

import org.napile.asm.AsmBuilder;
import org.napile.asm.io.xml.out.AsmTextTextWriter;

/**
 * @author VISTALL
 * @date 11:41/11.10.12
 */
public class XmlToTextTest
{
	public static void main(String... arg)
	{
		AsmBuilder builder = NodeUtil.createTestClassNode();

		List<String> result = builder.getResult(new AsmTextTextWriter());

		for(String s : result)
			System.out.println(s);
	}
}
