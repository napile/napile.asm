package org.napile.asm;

import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;

/**
 * @author VISTALL
 * @date 11:47/11.10.12
 */
public interface AsmConstants
{
	TypeNode ANY_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.ANY));

	TypeNode BOOL_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.BOOL));

	TypeNode NULL_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.NULL));

	TypeNode BYTE_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

	TypeNode SHORT_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

	TypeNode INT_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

	TypeNode STRING_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.STRING));

	TypeNode ARRAY__STRING__TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.ARRAY)).visitArgument(STRING_TYPE);

	String ANONYM_SPLITTER = "$";
}
