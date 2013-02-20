
package org.napile.asm.io.text.in.type;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class TypeNodeBaseListener implements TypeNodeListener {
	@Override public void enterThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void exitThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void enterMultiType(TypeNodeParser.MultiTypeContext ctx) { }
	@Override public void exitMultiType(TypeNodeParser.MultiTypeContext ctx) { }
	@Override public void enterMethodType(TypeNodeParser.MethodTypeContext ctx) { }
	@Override public void exitMethodType(TypeNodeParser.MethodTypeContext ctx) { }
	@Override public void enterMethodParameter(TypeNodeParser.MethodParameterContext ctx) { }
	@Override public void exitMethodParameter(TypeNodeParser.MethodParameterContext ctx) { }
	@Override public void enterTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void exitTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void enterQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void exitQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void enterMultiTypeEntry(TypeNodeParser.MultiTypeEntryContext ctx) { }
	@Override public void exitMultiTypeEntry(TypeNodeParser.MultiTypeEntryContext ctx) { }
	@Override public void enterClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void exitClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void enterReturnType(TypeNodeParser.ReturnTypeContext ctx) { }
	@Override public void exitReturnType(TypeNodeParser.ReturnTypeContext ctx) { }
	@Override public void enterTypePart(TypeNodeParser.TypePartContext ctx) { }
	@Override public void exitTypePart(TypeNodeParser.TypePartContext ctx) { }
	@Override public void enterTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx) { }
	@Override public void exitTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx) { }
	@Override public void enterArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void exitArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void enterVarOrValOrRef(TypeNodeParser.VarOrValOrRefContext ctx) { }
	@Override public void exitVarOrValOrRef(TypeNodeParser.VarOrValOrRefContext ctx) { }
	@Override public void enterNulled(TypeNodeParser.NulledContext ctx) { }
	@Override public void exitNulled(TypeNodeParser.NulledContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void exitEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void visitTerminal(ParseTree.TerminalNode<Token> node) { }
	@Override public void visitErrorNode(ParseTree.ErrorNode<Token> node) { }
}