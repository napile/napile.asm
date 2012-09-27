package org.napile.asm.io;

import java.util.HashSet;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.LangVersion;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.NodeVisitor;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class AsmWriter<A, R, W> implements NodeVisitor<A, R>
{
	protected LangVersion langVersion;

	private Set<AsmWriterOption> options = new HashSet<AsmWriterOption>(0);

	public void enableOption(@NotNull AsmWriterOption o)
	{
		options.add(o);
	}

	public void disableOption(@NotNull AsmWriterOption o)
	{
		options.add(o);
	}

	public boolean hasOption(@NotNull AsmWriterOption o)
	{
		return options.contains(o);
	}

	@NotNull
	public W write(@NotNull LangVersion langVersion, @NotNull ClassNode classNode)
	{
		start();

		this.langVersion = langVersion;

		classNode.accept(this, null);

		return getResult();
	}

	protected abstract void start();

	@NotNull
	protected abstract W getResult();
}
