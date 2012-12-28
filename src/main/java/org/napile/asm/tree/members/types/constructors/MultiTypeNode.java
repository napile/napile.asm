package org.napile.asm.tree.members.types.constructors;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.Modifier;
import org.napile.asm.tree.members.NodeVisitor;
import org.napile.asm.tree.members.VariableNode;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.Function;

/**
 * @author VISTALL
 * @date 12:03/28.12.12
 */
public class MultiTypeNode implements TypeConstructorNode
{
	@NotNull
	public final List<VariableNode> variables = new ArrayList<VariableNode>(1);

	@Override
	public <T, R> R accept(@NotNull NodeVisitor<T, R> visitor, T arg)
	{
		return visitor.visitMultiTypeNode(this, arg);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != MultiTypeNode.class)
			return false;

		MultiTypeNode oType = (MultiTypeNode) o;

		return Comparing.equal(variables, oType.variables);
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("[");
		b.append(StringUtil.join(variables, new Function<VariableNode, String>()
		{
			@Override
			public String fun(VariableNode variableNode)
			{
				StringBuilder b = new StringBuilder();
				if(ArrayUtil.contains(Modifier.MUTABLE, variableNode.modifiers))
					b.append("var ");
				else
					b.append("val ");
				b.append(variableNode.name).append(" : ").append(variableNode.returnType);
				return b.toString();
			}
		}, ", "));

		b.append("]");
		return b.toString();
	}
}
