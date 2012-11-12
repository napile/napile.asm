package org.napile.asm.util;

/**
 * @author VISTALL
 * @date 19:50/12.11.12
 */
public class StringWrapper
{
	public static String wrapToXml(String str)
	{
		return str.replace("\n", "\\n").replace("\t", "\\t").replace("\r", "\\r");
	}

	public static String unwrapFromXml(String str)
	{
		return str.replace("\\n", "\n").replace("\\t", "\t").replace("\\r", "\r");
	}
}
