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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;
import org.napile.asm.tree.members.types.TypeNode;

/**
 * @author VISTALL
 * @date 1:47/02.09.12
 */
public class TypeNodeUtil
{
	public static TypeNode fromString(@NotNull String string)
	{
		TypeNodeLexer lexer = new TypeNodeLexer(null);
		TypeNodeParser parser = new TypeNodeParser(null);
		parser.setBuildParseTree(true);

		lexer.setInputStream(new ANTLRInputStream(string));

		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		tokenStream.fill();
		parser.setTokenStream(tokenStream);


		TypeNodeParser.TypeNodeContext typeNode = parser.typeNode();

		TypeNodeWorker worker = new TypeNodeWorker(tokenStream);
		typeNode.enterRule(worker);
		return worker.toType();
	}
}
