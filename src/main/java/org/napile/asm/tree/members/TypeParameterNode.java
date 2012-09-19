package org.napile.asm.tree.members;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 18:33/31.08.12
 */
public class TypeParameterNode extends AnnotableNode<TypeParameterNode>
{
	@NotNull
	public final List<ClassTypeNode> supers = new ArrayList<ClassTypeNode>(1);

	@NotNull
	public final String name;

	public TypeParameterNode(@NotNull String name)
	{
		this.name = name;
	}

	@Override
	public <T> void accept(@NotNull NodeVisitor<T> visitor, T arg)
	{
		visitor.visitTypeParameter(this, arg);
	}

	public TypeParameterNode visitSuper(@NotNull String s)
	{
		return visitSuper(new ClassTypeNode(new FqName(s)));
	}

	public TypeParameterNode visitSuper(@NotNull FqName fqName)
	{
		return visitSuper(new ClassTypeNode(fqName));
	}

	public TypeParameterNode visitSuper(@NotNull ClassTypeNode typeNode)
	{
		supers.add(typeNode);
		return this;
	}
}
