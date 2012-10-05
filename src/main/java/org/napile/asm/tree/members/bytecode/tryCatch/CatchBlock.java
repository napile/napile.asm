package org.napile.asm.tree.members.bytecode.tryCatch;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 13:57/05.10.12
 */
public class CatchBlock
{
	public final int startIndex;
	public final int endIndex;
	public final int variableIndex;
	@NotNull
	public final TypeNode exception;

	public CatchBlock(int startIndex, int endIndex, int variableIndex, @NotNull TypeNode exception)
	{
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.variableIndex = variableIndex;
		this.exception = exception;
	}
}
