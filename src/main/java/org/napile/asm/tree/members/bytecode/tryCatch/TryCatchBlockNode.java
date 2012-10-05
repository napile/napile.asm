package org.napile.asm.tree.members.bytecode.tryCatch;

import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.Node;
import org.napile.asm.tree.members.NodeVisitor;

/**
 * @author VISTALL
 * @date 14:01/05.10.12
 */
public class TryCatchBlockNode implements Node
{
	@NotNull
	public final TryBlock tryBlock;
	@NotNull
	public final List<CatchBlock> catchBlocks;

	public TryCatchBlockNode(@NotNull TryBlock tryBlock, @NotNull List<CatchBlock> catchBlocks)
	{
		this.tryBlock = tryBlock;
		this.catchBlocks = Collections.unmodifiableList(catchBlocks);
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitTryCatchBlockNode(this, arg);
	}
}
