package org.napile.asm.io.xml.out;

import java.util.List;

import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.io.AsmWriter;
import org.napile.asm.tree.members.AbstractMemberNode;
import org.napile.asm.tree.members.AnnotationNode;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.MacroNode;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.Node;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.MethodTypeNode;
import org.napile.asm.tree.members.types.constructors.MultiTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.Function;

/**
 * @author VISTALL
 * @date 11:42/11.10.12
 */
public abstract class AbstractAsmTextWriter<A> extends AsmWriter<StringBuilder, StringBuilder, A>
{
	private class NodeAcceptorFunction implements Function<Node, String>
	{
		@Override
		public String fun(Node node)
		{
			StringBuilder b = new StringBuilder();
			node.accept(AbstractAsmTextWriter.this, b);
			return b.toString();
		}
	}

	private final Function<? extends Node, String> func = new NodeAcceptorFunction();
	protected StringBuilder builder;

	private int indent;

	@Override
	protected void start()
	{
		builder = new StringBuilder();
	}

	@Override
	public StringBuilder visitAnnotationNode(AnnotationNode annotationNode, StringBuilder a2)
	{
		return null;
	}

	@Override
	public StringBuilder visitClassNode(ClassNode classNode, StringBuilder a2)
	{
		String shortName = classNode.name.shortName().getName();
		if(!shortName.contains(AsmConstants.ANONYM_SPLITTER))
			builder.append("package ").append(classNode.name.parent().getFqName()).append("\n\n");

		builder.append(StringUtil.repeat("\t", indent));
		renderModifiers(builder, classNode.modifiers);
		builder.append("class ");

		builder.append(shortName);

		renderTypeParameters(builder, classNode);

		if(!classNode.supers.isEmpty())
		{
			builder.append(" : ");

			builder.append(StringUtil.join(classNode.supers, (Function<TypeNode,String>) func, ", "));
		}

		builder.append("\n");
		builder.append(StringUtil.repeat("\t", indent));
		builder.append("{").append("\n");
		indent ++;
		builder.append(StringUtil.join(classNode.getMembers(), new Function<AbstractMemberNode, String>()
		{
			@Override
			public String fun(AbstractMemberNode abstractMemberNode)
			{
				StringBuilder b = new StringBuilder();
				b.append(StringUtil.repeat("\t", indent));
				abstractMemberNode.accept(AbstractAsmTextWriter.this, b);
				return b.toString();
			}
		}, "\n\n"));

		indent --;

		builder.append("\n");
		builder.append(StringUtil.repeat("\t", indent));
		builder.append("}");
		return builder;
	}

	@Override
	public StringBuilder visitMethodNode(MethodNode methodNode, StringBuilder a2)
	{
		renderModifiers(a2, methodNode.modifiers);
		a2.append("meth ");
		a2.append(methodNode.name);
		renderTypeParameters(a2, methodNode);
		a2.append("(");
		a2.append(StringUtil.join(methodNode.parameters, (Function<MethodParameterNode,String>) func, ", "));
		a2.append(")");
		a2.append(" : ");
		a2.append(methodNode.returnType);
		return a2;
	}

	@Override
	public StringBuilder visitMacroNode(MacroNode methodNode, StringBuilder a2)
	{
		renderModifiers(a2, methodNode.modifiers);
		a2.append("macro ");
		a2.append(methodNode.name);
		renderTypeParameters(a2, methodNode);
		a2.append("(");
		a2.append(StringUtil.join(methodNode.parameters, (Function<MethodParameterNode,String>) func, ", "));
		a2.append(")");
		a2.append(" : ");
		a2.append(methodNode.returnType);
		return a2;
	}

	@Override
	public StringBuilder visitVariableNode(VariableNode variableNode, StringBuilder a2)
	{
		renderModifiers(a2, variableNode.modifiers);
		if(ArrayUtil.contains(Modifier.MUTABLE, variableNode.modifiers))
			a2.append("var ");
		else
			a2.append("val ") ;
		a2.append(variableNode.name);
		a2.append(" : ");
		a2.append(variableNode.returnType);
		return a2;
	}

	@Override
	public StringBuilder visitMethodParameterNode(MethodParameterNode methodParameterNode, StringBuilder a2)
	{
		renderModifiers(a2, methodParameterNode.modifiers);
		if(ArrayUtil.contains(Modifier.MUTABLE, methodParameterNode.modifiers))
			a2.append("var ");
		else
			a2.append("val ") ;
		a2.append(methodParameterNode.name);
		a2.append(" : ");
		methodParameterNode.returnType.accept(this, a2);
		if(methodParameterNode.defaultValue != null)
		{
			a2.append(" = ").append(methodParameterNode.defaultValue);
		}
		return a2;
	}

	@Override
	public StringBuilder visitTypeParameter(TypeParameterNode typeParameterNode, StringBuilder b)
	{
		b.append(typeParameterNode.name);
		if(!typeParameterNode.supers.isEmpty())
		{
			b.append(" : ");
			if(typeParameterNode.supers.size() == 1)
				b.append(typeParameterNode.supers.get(0));
			else
			{
				b.append("[");
				b.append(StringUtil.join(typeParameterNode.supers, (Function<TypeNode,String>) func, ", "));
				b.append("]");
			}
		}

		b.append(StringUtil.join(typeParameterNode.constructors, new Function<List<MethodParameterNode>, String>()
		{
			@Override
			public String fun(List<MethodParameterNode> methodParameterNodes)
			{
				StringBuilder b = new StringBuilder();
				b.append("(");
				b.append(StringUtil.join(methodParameterNodes, (Function<MethodParameterNode,String>) func, ", "));
				b.append(")");
				return b.toString();
			}
		}, ""));
		return b;
	}

	@Override
	public StringBuilder visitTypeNode(TypeNode typeNode, StringBuilder a2)
	{
		//TODO [VISTALL] annotations
		typeNode.typeConstructorNode.accept(this, a2);

		if(!typeNode.arguments.isEmpty())
		{
			a2.append("<");
			a2.append(StringUtil.join(typeNode.arguments, (Function<TypeNode,String>) func, ", "));
			a2.append(">");
		}

		if(typeNode.nullable)
			a2.append("?");
		return a2;
	}

	@Override
	public StringBuilder visitClassTypeNode(ClassTypeNode classTypeNode, StringBuilder a2)
	{
		return a2.append(classTypeNode.className.getFqName());
	}

	@Override
	public StringBuilder visitThisTypeNode(ThisTypeNode thisTypeNode, StringBuilder a2)
	{
		return a2.append("this");
	}

	@Override
	public StringBuilder visitMethodTypeNode(MethodTypeNode methodTypeNode, StringBuilder a2)
	{
		a2.append("{");
		a2.append("(");
		a2.append(StringUtil.join(methodTypeNode.parameters, (Function<MethodParameterNode,String>) func, ", "));
		a2.append(")");
		a2.append(" : ");
		methodTypeNode.returnType.accept(this, a2);
		a2.append("}");
		return a2;
	}

	@Override
	public StringBuilder visitMultiTypeNode(MultiTypeNode multiTypeNode, StringBuilder a2)
	{
		a2.append("[");
		a2.append(StringUtil.join(multiTypeNode.variables, (Function<VariableNode, String>) func, ", "));
		a2.append("]");
		return a2;
	}

	@Override
	public StringBuilder visitTypeParameterValueTypeNode(TypeParameterValueTypeNode typeParameterValueTypeNode, StringBuilder a2)
	{
		return a2.append(typeParameterValueTypeNode.name);
	}

	@Override
	public StringBuilder visitTryCatchBlockNode(TryCatchBlockNode tryCatchBlockNode, StringBuilder arg)
	{
		return null;
	}

	private void renderTypeParameters(final StringBuilder c, AbstractMemberNode<?> memberNode)
	{
		if(!memberNode.typeParameters.isEmpty())
		{
			c.append("<");
			c.append(StringUtil.join(memberNode.typeParameters, (Function<TypeParameterNode,String>) func, ", "));
			c.append(">");
		}
	}

	private static void renderModifiers(StringBuilder b, Modifier[] modifiers)
	{
		for(Modifier m : modifiers)
			if(m != Modifier.MUTABLE)
				b.append(m.name().toLowerCase()).append(" ");
	}
}
