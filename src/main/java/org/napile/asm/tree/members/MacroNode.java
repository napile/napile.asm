package org.napile.asm.tree.members;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.Name;

/**
 * @author VISTALL
 * @date 17:28/21.11.12
 */
public class MacroNode extends MethodNode
{
	public MacroNode(@NotNull Modifier[] modifiers, @NotNull Name name)
	{
		super(modifiers, name);
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitMacroNode(this, arg);
	}
}
