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

	TypeNode BYTE_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.BYTE));

	TypeNode SHORT_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.SHORT));

	TypeNode INT_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.INT));

	TypeNode LONG_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.LONG));

	TypeNode FLOAT_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.FLOAT));

	TypeNode DOUBLE_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.DOUBLE));

	TypeNode CHAR_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.CHAR));

	TypeNode STRING_TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.STRING));

	TypeNode ARRAY__STRING__TYPE = new TypeNode(false, new ClassTypeNode(NapileLangPackage.ARRAY)).visitArgument(STRING_TYPE);

	String ANONYM_SPLITTER = "$";
}
