package org.napile.asm.tree.members;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asmNew.Modifier;

/**
 * @author VISTALL
 * @date 17:32/31.08.12
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMemberNode<T extends AbstractMemberNode<T>> extends AnnotableNode<T>
{
	@NotNull
	public final Modifier[] modifiers;

	@NotNull
	public final List<TypeParameterNode> typeParameters = new ArrayList<TypeParameterNode>(0);

	public AbstractMemberNode(@NotNull Modifier[] modifiers)
	{
		this.modifiers = modifiers;
	}

	public TypeParameterNode visitTypeParameter(@NotNull String name)
	{
		TypeParameterNode typeParameterNode = new TypeParameterNode(name);

		typeParameters.add(typeParameterNode);

		return typeParameterNode;
	}
}
