package org.napile.asm.io.xml.out;

import org.jetbrains.annotations.NotNull;

/**
 * @author VISTALL
 * @date 11:44/11.10.12
 */
public class AsmTextTextWriter extends AbstractAsmTextWriter<String>
{
	@NotNull
	@Override
	protected String getResult()
	{
		return builder.toString();
	}
}
