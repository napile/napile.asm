package org.napile.asm.evaluator.invokeAnonym;

import java.io.FileReader;

import org.napile.asm.io.xml.in.AsmXmlFileReader;
import org.napile.asm.tree.members.ClassNode;

/**
 * @author VISTALL
 * @date 17:08/22.12.12
 */
public class ThreadTest
{
	public static void main(String... arg)  throws Exception
	{
		AsmXmlFileReader r = new AsmXmlFileReader();

		ClassNode c = r.read(new FileReader("I:\\github.com\\napile-lang\\napile.asm\\src\\test\\java\\org\\napile\\asm\\evaluator\\invokeAnonym\\Thread.nxml"));
	}
}
