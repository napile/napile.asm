package org.napile.asm.tree.members.types;

import org.jetbrains.annotations.NotNull;
import org.napile.asmNew.visitors.AsmVisitor;

/**
 * @author VISTALL
 * @date 18:32/31.08.12
 */
public class ThisTypeNode implements TypeConstructorNode
{
	@Override
	public <T> void accept(@NotNull AsmVisitor<T> visitor, T arg)
	{
		visitor.visitThisTypeNode(this, arg);
	}

	@Override
	public boolean equals(Object o)
	{
		return o instanceof ThisTypeNode;
	}

	@Override
	public String toString()
	{
		return "this";
	}
}
