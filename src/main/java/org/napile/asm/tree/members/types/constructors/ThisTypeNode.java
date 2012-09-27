package org.napile.asm.tree.members.types.constructors;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.NodeVisitor;

/**
 * @author VISTALL
 * @date 18:32/31.08.12
 */
public class ThisTypeNode implements TypeConstructorNode
{
	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitThisTypeNode(this, arg);
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
