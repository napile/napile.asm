
package org.napile.asm.parsing.type;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface TypeNodeListener extends ParseTreeListener<Token> {
	void enterTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx);
	void exitTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx);
	void enterThisType(TypeNodeParser.ThisTypeContext ctx);
	void exitThisType(TypeNodeParser.ThisTypeContext ctx);
	void enterTypePart(TypeNodeParser.TypePartContext ctx);
	void exitTypePart(TypeNodeParser.TypePartContext ctx);
	void enterArguments(TypeNodeParser.ArgumentsContext ctx);
	void exitArguments(TypeNodeParser.ArgumentsContext ctx);
	void enterTypeNode(TypeNodeParser.TypeNodeContext ctx);
	void exitTypeNode(TypeNodeParser.TypeNodeContext ctx);
	void enterQualifiedName(TypeNodeParser.QualifiedNameContext ctx);
	void exitQualifiedName(TypeNodeParser.QualifiedNameContext ctx);
	void enterClassType(TypeNodeParser.ClassTypeContext ctx);
	void exitClassType(TypeNodeParser.ClassTypeContext ctx);
	void enterNulled(TypeNodeParser.NulledContext ctx);
	void exitNulled(TypeNodeParser.NulledContext ctx);
}