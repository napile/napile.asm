package org.napile.asm.writters;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.NodeVisitor;
import org.napile.asm.LangVersion;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class AsmWriter<T, R> implements NodeVisitor<T>
{
	protected LangVersion langVersion;

	@NotNull
	public R write(@NotNull LangVersion langVersion, @NotNull ClassNode classNode)
	{
		start();

		this.langVersion = langVersion;

		classNode.accept(this, null);

		return getResult();
	}

	protected abstract void start();

	@NotNull
	protected abstract R getResult();
}
