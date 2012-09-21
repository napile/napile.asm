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

// $ANTLR ANTLRVersion> TypeNodeLexerLexer.java generatedTimestamp>

package org.napile.asm.io.text.in.type;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeLexerLexer extends Lexer {
	public static final int
		T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Identifier=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'.'", "','", "'<'", "'?'", "Identifier"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", "Letter", 
		"JavaIDDigit"
	};


	public TypeNodeLexerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN);
	}

	@Override
	public String getGrammarFileName() { return "TypeNode.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }


	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch ( ruleIndex ) {
			case 0 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 6 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 7 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 8 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void JavaIDDigit_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Letter_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Identifier_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__1_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__0_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__3_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__5_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__2_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__4_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}

	public static final String _serializedATN =
		"\2\ti\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6"+
		"\2\7\7\7\2\b\7\b\1\0\1\0\1\0\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1"+
		"\5\1\5\1\6\0\1\6\0\1\6\0\5\6\b\6\n\6\f\6,\t\6\1\7\0\1\7\0\1\7\0\1\7\0"+
		"\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\3\7\b\7\1\b\0\1"+
		"\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0"+
		"\1\b\0\1\b\0\3\b\b\b\t\1\3\uffff\3\4\uffff\5\5\uffff\7\6\uffff\t\7\uffff"+
		"\13\b\uffff\r\t\uffff\17\0\uffff\21\0\uffff\1\0\0c\0\1\1\0\0\0\0\3\1\0"+
		"\0\0\0\5\1\0\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\1\23"+
		"\1\0\0\0\3\30\1\0\0\0\5\32\1\0\0\0\7\34\1\0\0\0\t\36\1\0\0\0\13 \1\0\0"+
		"\0\r\"\1\0\0\0\17G\1\0\0\0\21g\1\0\0\0\23\24\5t\0\0\24\25\5h\0\0\25\26"+
		"\5i\0\0\26\27\5s\0\0\27\2\1\0\0\0\30\31\5>\0\0\31\4\1\0\0\0\32\33\5.\0"+
		"\0\33\6\1\0\0\0\34\35\5,\0\0\35\b\1\0\0\0\36\37\5<\0\0\37\n\1\0\0\0 !"+
		"\5?\0\0!\f\1\0\0\0\"*\3\17\7\0$)\3\17\7\0&)\3\21\b\0($\1\0\0\0(&\1\0\0"+
		"\0),\1\0\0\0*(\1\0\0\0*+\1\0\0\0+\16\1\0\0\0,*\1\0\0\0-H\5$\0\0/H\2AZ"+
		"\0\61H\5_\0\0\63H\2az\0\65H\2\u00c0\u00d6\0\67H\2\u00d8\u00f6\09H\2\u00f8"+
		"\u00ff\0;H\2\u0100\u1fff\0=H\2\u3040\u318f\0?H\2\u3300\u337f\0AH\2\u3400"+
		"\u3d2d\0CH\2\u4e00\u9fff\0EH\2\uf900\ufaff\0G-\1\0\0\0G/\1\0\0\0G\61\1"+
		"\0\0\0G\63\1\0\0\0G\65\1\0\0\0G\67\1\0\0\0G9\1\0\0\0G;\1\0\0\0G=\1\0\0"+
		"\0G?\1\0\0\0GA\1\0\0\0GC\1\0\0\0GE\1\0\0\0H\20\1\0\0\0Ih\2\609\0Kh\2\u0660"+
		"\u0669\0Mh\2\u06f0\u06f9\0Oh\2\u0966\u096f\0Qh\2\u09e6\u09ef\0Sh\2\u0a66"+
		"\u0a6f\0Uh\2\u0ae6\u0aef\0Wh\2\u0b66\u0b6f\0Yh\2\u0be7\u0bef\0[h\2\u0c66"+
		"\u0c6f\0]h\2\u0ce6\u0cef\0_h\2\u0d66\u0d6f\0ah\2\u0e50\u0e59\0ch\2\u0ed0"+
		"\u0ed9\0eh\2\u1040\u1049\0gI\1\0\0\0gK\1\0\0\0gM\1\0\0\0gO\1\0\0\0gQ\1"+
		"\0\0\0gS\1\0\0\0gU\1\0\0\0gW\1\0\0\0gY\1\0\0\0g[\1\0\0\0g]\1\0\0\0g_\1"+
		"\0\0\0ga\1\0\0\0gc\1\0\0\0ge\1\0\0\0h\22\1\0\0\0\5\0\1(\1*\1G\1g\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}