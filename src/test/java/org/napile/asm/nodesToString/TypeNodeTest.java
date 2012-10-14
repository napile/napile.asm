package org.napile.asm.nodesToString;

import org.junit.Assert;
import org.junit.Test;
import org.napile.asm.AsmConstants;
import org.napile.asm.Modifier;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.MethodTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.io.text.in.type.TypeNodeUtil;
import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;

/**
 * @author VISTALL
 * @date 23:48/01.09.12
 */
public class TypeNodeTest
{
	@Test
	public void test1()
	{
		createAndParserCheck(new TypeNode(false, new ClassTypeNode(NapileLangPackage.ANY)), "napile.lang.Any");
	}

	@Test
	public void test2()
	{
		createAndParserCheck(new TypeNode(false, new ClassTypeNode(NapileLangPackage.ANY)).visitArgument(new TypeNode(true, new ClassTypeNode(NapileLangPackage.DOUBLE))), "napile.lang.Any<napile.lang.Double?>");
	}

	@Test
	public void test3()
	{
		TypeNode type = new TypeNode(false, new ClassTypeNode(NapileLangPackage.ANY));
		type.visitArgument(new TypeNode(true, new ClassTypeNode(NapileLangPackage.DOUBLE)));
		type.visitArgument(new TypeNode(false, new ThisTypeNode()));

		createAndParserCheck(type, "napile.lang.Any<napile.lang.Double?, this>");
	}

	@Test
	public void test4()
	{
		TypeNode type = new TypeNode(false, new TypeParameterValueTypeNode(Name.identifier("E")));
		type.visitArgument(new TypeNode(true, new ClassTypeNode(NapileLangPackage.DOUBLE)));
		type.visitArgument(new TypeNode(false, new ThisTypeNode()));

		createAndParserCheck(type, ":E:<napile.lang.Double?, this>");
	}

	@Test
	public void test5()
	{
		MethodTypeNode methodTypeNode = new MethodTypeNode();
		methodTypeNode.parameters.add(new MethodParameterNode(Modifier.EMPTY, Name.identifier("p1"), AsmConstants.BOOL_TYPE));
		methodTypeNode.returnType = AsmConstants.INT_TYPE;

		TypeNode type = new TypeNode(false, methodTypeNode);

		createAndParserCheck(type, "{(p1 : napile.lang.Bool) : napile.lang.Int}");
	}

	private static void createAndParserCheck(final TypeNode typeNode, final String type)
	{
		System.out.println("checking '" + typeNode + "' to '" + type + "'");

		String out = typeNode.toString();

		Assert.assertTrue(out.equals(type));

		TypeNode parsedType = TypeNodeUtil.fromString(out);

		System.out.println("checking '" + typeNode + "' to parsed '" + parsedType + "'");

		Assert.assertTrue(parsedType.equals(typeNode));
	}
}
