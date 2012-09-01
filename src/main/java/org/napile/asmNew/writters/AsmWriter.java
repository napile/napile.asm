package org.napile.asmNew.writters;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asmNew.LangVersion;
import org.napile.asmNew.visitors.AsmVisitor;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class AsmWriter<T, R> implements AsmVisitor<T>
{
	protected LangVersion langVersion;

	public void write(@NotNull LangVersion langVersion, @NotNull ClassNode classNode)
	{
		start();

		this.langVersion = langVersion;

		classNode.accept(this, null);
	}

	protected abstract void start();

	@NotNull
	public abstract R getResult();
}
