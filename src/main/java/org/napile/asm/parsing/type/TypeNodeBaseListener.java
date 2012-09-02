
package org.napile.asm.parsing.type;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class TypeNodeBaseListener implements TypeNodeListener {
	@Override public void enterThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void exitThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void enterArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void exitArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void enterTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void exitTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void enterQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void exitQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void enterClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void exitClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void enterClassOrThisType(TypeNodeParser.ClassOrThisTypeContext ctx) { }
	@Override public void exitClassOrThisType(TypeNodeParser.ClassOrThisTypeContext ctx) { }
	@Override public void enterNulled(TypeNodeParser.NulledContext ctx) { }
	@Override public void exitNulled(TypeNodeParser.NulledContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void exitEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void visitTerminal(ParseTree.TerminalNode<Token> node) { }
	@Override public void visitErrorNode(ParseTree.ErrorNode<Token> node) { }
}