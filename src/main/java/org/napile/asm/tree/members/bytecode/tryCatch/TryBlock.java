package org.napile.asm.tree.members.bytecode.tryCatch;

/**
 * @author VISTALL
 * @date 13:57/05.10.12
 */
public class TryBlock
{
	public final int startIndex;
	public final int endIndex;

	public TryBlock(int startIndex, int endIndex)
	{
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
}
