
/*
 * Copyright 2010-2012 napile.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.napile.asm.io.text.in.type;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class TypeNodeBaseListener implements TypeNodeListener {
	@Override public void enterTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx) { }
	@Override public void exitTypeParameterValue(TypeNodeParser.TypeParameterValueContext ctx) { }
	@Override public void enterThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void exitThisType(TypeNodeParser.ThisTypeContext ctx) { }
	@Override public void enterTypePart(TypeNodeParser.TypePartContext ctx) { }
	@Override public void exitTypePart(TypeNodeParser.TypePartContext ctx) { }
	@Override public void enterArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void exitArguments(TypeNodeParser.ArgumentsContext ctx) { }
	@Override public void enterTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void exitTypeNode(TypeNodeParser.TypeNodeContext ctx) { }
	@Override public void enterQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void exitQualifiedName(TypeNodeParser.QualifiedNameContext ctx) { }
	@Override public void enterClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void exitClassType(TypeNodeParser.ClassTypeContext ctx) { }
	@Override public void enterNulled(TypeNodeParser.NulledContext ctx) { }
	@Override public void exitNulled(TypeNodeParser.NulledContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void exitEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void visitTerminal(ParseTree.TerminalNode<Token> node) { }
	@Override public void visitErrorNode(ParseTree.ErrorNode<Token> node) { }
}