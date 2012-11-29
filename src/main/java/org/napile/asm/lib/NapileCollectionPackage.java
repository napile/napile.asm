package org.napile.asm.lib;

import org.napile.asm.resolve.name.FqName;
import org.napile.asm.resolve.name.Name;

/**
 * @author VISTALL
 * @date 14:13/29.11.12
 */
public interface NapileCollectionPackage
{
	FqName PACKAGE = new FqName("napile.collection");

	FqName ITERATOR = PACKAGE.child(Name.identifier("Iterator"));
}
