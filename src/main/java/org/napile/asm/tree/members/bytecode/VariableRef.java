package org.napile.asm.tree.members.bytecode;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.compiler.lang.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 13:51/02.09.12
 */
public class VariableRef
{
	@NotNull
	public final FqName variable;
	@NotNull
	public final TypeNode returnType;

	public VariableRef(@NotNull FqName variable, @NotNull TypeNode returnType)
	{
		this.variable = variable;
		this.returnType = returnType;
	}
}
