
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