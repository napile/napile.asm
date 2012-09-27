package org.napile.asm.tree.members;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 18:33/31.08.12
 */
public class TypeParameterNode extends AnnotableNode<TypeParameterNode>
{
	@NotNull
	public final List<TypeNode> supers = new ArrayList<TypeNode>(1);

	@NotNull
	public final String name;

	public TypeParameterNode(@NotNull String name)
	{
		this.name = name;
	}

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitTypeParameter(this, arg);
	}
}
