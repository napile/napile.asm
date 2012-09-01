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

package org.napile.asmNew.parsing.type;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.tree.members.types.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeConstructorNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.compiler.lang.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 0:56/02.09.12
 */
public class TypeNodeWorker extends TypeNodeBaseListener
{
	private final TokenStream tokenStream;

	private TypeConstructorNode typeConstructorNode;
	private boolean nullable;
	private List<TypeNode> arguments = new ArrayList<TypeNode>();

	public TypeNodeWorker(TokenStream tokenStream)
	{
		this.tokenStream = tokenStream;
	}

	@Override
	public void enterTypeNode(TypeNodeParser.TypeNodeContext ctx)
	{
		acceptChild(ctx);
	}

	@Override
	public void enterClassOrThisType(TypeNodeParser.ClassOrThisTypeContext ctx)
	{
		acceptChild(ctx);
	}

	@Override
	public void enterThisType(TypeNodeParser.ThisTypeContext ctx)
	{
		typeConstructorNode = new ThisTypeNode();
	}

	@Override
	public void enterClassType(TypeNodeParser.ClassTypeContext ctx)
	{
		typeConstructorNode = new ClassTypeNode(new FqName(ctx.qualifiedName().getText(tokenStream)));
	}

	@Override
	public void enterArguments(TypeNodeParser.ArgumentsContext ctx)
	{
		List<? extends TypeNodeParser.TypeNodeContext> typeNodes = ctx.typeNode();
		for(TypeNodeParser.TypeNodeContext context : typeNodes)
		{
			TypeNodeWorker worker = new TypeNodeWorker(tokenStream);
			worker.acceptChild(context);

			arguments.add(worker.toType());
		}
	}

	@Override
	public void enterNulled(TypeNodeParser.NulledContext ctx)
	{
		nullable = true;
	}

	protected void acceptChild(@NotNull ParserRuleContext<Token> parserRuleContext)
	{
		for(int i = 0; i < parserRuleContext.getChildCount(); i++)
		{
			ParseTree parserTree = parserRuleContext.getChild(i);
			if(parserTree instanceof ParserRuleContext)
				((ParserRuleContext) parserTree).enterRule(this);
			else if(parserTree instanceof ParseTree.TerminalNode)
				visitTerminal((ParseTree.TerminalNode)parserTree);
		}
	}

	@NotNull
	public TypeNode toType()
	{
		TypeNode typeNode = new TypeNode(nullable, typeConstructorNode);
		for(TypeNode t : arguments)
			typeNode.visitArgument(t);
		return typeNode;
	}
}
