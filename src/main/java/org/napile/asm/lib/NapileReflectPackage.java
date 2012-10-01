package org.napile.asm.lib;

import org.napile.asm.resolve.name.FqName;
import org.napile.asm.resolve.name.Name;

/**
 * @author VISTALL
 * @date 23:34/01.09.12
 */
public interface NapileReflectPackage
{
	FqName PACKAGE = new FqName("napile.reflect");

	FqName CLASS = PACKAGE.child(Name.identifier("Class"));

	FqName TYPE = PACKAGE.child(Name.identifier("Type"));
}
