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

// $ANTLR ANTLRVersion> TypeNodeLexer.java generatedTimestamp>

package org.napile.asm.io.text.in.type;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeLexer extends Lexer {
	public static final int
		T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, Identifier=10, 
		WS=11, COMMENT=12, LINE_COMMENT=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'.'", "','", "':'", "'<'", "'?'", "Identifier", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", 
		"Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT"
	};


	public TypeNodeLexer(CharStream input) {
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
			case 0 : T__6_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 6 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 7 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 8 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 9 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 10 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 11 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 12 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void WS_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 0 : _channel = HIDDEN; break;
		}
	}
	public void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 2 : _channel = HIDDEN; break;
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
	public void T__2_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void JavaIDDigit_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 1 : _channel = HIDDEN; break;
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
	public void T__6_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__5_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__4_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}

	public static final String _serializedATN =
		"\2\r\u009c\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6"+
		"\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\1\0\1\0\1\0\1\0"+
		"\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\7\0\1\7\0\1\7\0"+
		"\5\7\b\7\n\7\f\7\66\t\7\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b"+
		"\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\3\b\b\b\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0"+
		"\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\1\t\0\3\t\b\t\1"+
		"\n\0\4\n\b\n\13\n\f\nw\1\n\1\n\1\13\1\13\1\13\1\13\0\5\13\b\13\n\13\f"+
		"\13\u0084\t\13\1\13\1\13\1\13\1\13\1\13\1\f\1\f\1\f\1\f\0\5\f\b\f\n\f"+
		"\f\f\u0093\t\f\1\f\0\3\f\b\f\1\f\0\1\f\1\f\r\1\3\uffff\3\4\uffff\5\5\uffff"+
		"\7\6\uffff\t\7\uffff\13\b\uffff\r\t\uffff\17\n\uffff\21\0\uffff\23\0\uffff"+
		"\25\13\0\27\f\1\31\r\2\1\0\2\3\t\n\f\r  \2\n\n\r\r\u0095\0\1\1\0\0\0\0"+
		"\3\1\0\0\0\0\5\1\0\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0"+
		"\0\0\17\1\0\0\0\0\25\1\0\0\0\0\27\1\0\0\0\0\31\1\0\0\0\1\33\1\0\0\0\3"+
		" \1\0\0\0\5\"\1\0\0\0\7$\1\0\0\0\t&\1\0\0\0\13(\1\0\0\0\r*\1\0\0\0\17"+
		",\1\0\0\0\21Q\1\0\0\0\23q\1\0\0\0\25u\1\0\0\0\27{\1\0\0\0\31\u008a\1\0"+
		"\0\0\33\34\5t\0\0\34\35\5h\0\0\35\36\5i\0\0\36\37\5s\0\0\37\2\1\0\0\0"+
		" !\5>\0\0!\4\1\0\0\0\"#\5.\0\0#\6\1\0\0\0$%\5,\0\0%\b\1\0\0\0&\'\5:\0"+
		"\0\'\n\1\0\0\0()\5<\0\0)\f\1\0\0\0*+\5?\0\0+\16\1\0\0\0,\64\3\21\b\0."+
		"\63\3\21\b\0\60\63\3\23\t\0\62.\1\0\0\0\62\60\1\0\0\0\63\66\1\0\0\0\64"+
		"\62\1\0\0\0\64\65\1\0\0\0\65\20\1\0\0\0\66\64\1\0\0\0\67R\5$\0\09R\2A"+
		"Z\0;R\5_\0\0=R\2az\0?R\2\u00c0\u00d6\0AR\2\u00d8\u00f6\0CR\2\u00f8\u00ff"+
		"\0ER\2\u0100\u1fff\0GR\2\u3040\u318f\0IR\2\u3300\u337f\0KR\2\u3400\u3d2d"+
		"\0MR\2\u4e00\u9fff\0OR\2\uf900\ufaff\0Q\67\1\0\0\0Q9\1\0\0\0Q;\1\0\0\0"+
		"Q=\1\0\0\0Q?\1\0\0\0QA\1\0\0\0QC\1\0\0\0QE\1\0\0\0QG\1\0\0\0QI\1\0\0\0"+
		"QK\1\0\0\0QM\1\0\0\0QO\1\0\0\0R\22\1\0\0\0Sr\2\609\0Ur\2\u0660\u0669\0"+
		"Wr\2\u06f0\u06f9\0Yr\2\u0966\u096f\0[r\2\u09e6\u09ef\0]r\2\u0a66\u0a6f"+
		"\0_r\2\u0ae6\u0aef\0ar\2\u0b66\u0b6f\0cr\2\u0be7\u0bef\0er\2\u0c66\u0c6f"+
		"\0gr\2\u0ce6\u0cef\0ir\2\u0d66\u0d6f\0kr\2\u0e50\u0e59\0mr\2\u0ed0\u0ed9"+
		"\0or\2\u1040\u1049\0qS\1\0\0\0qU\1\0\0\0qW\1\0\0\0qY\1\0\0\0q[\1\0\0\0"+
		"q]\1\0\0\0q_\1\0\0\0qa\1\0\0\0qc\1\0\0\0qe\1\0\0\0qg\1\0\0\0qi\1\0\0\0"+
		"qk\1\0\0\0qm\1\0\0\0qo\1\0\0\0r\24\1\0\0\0sv\7\0\0\0us\1\0\0\0vw\1\0\0"+
		"\0wu\1\0\0\0wx\1\0\0\0xy\1\0\0\0yz\6\n\0\0z\26\1\0\0\0{|\5/\0\0|}\5*\0"+
		"\0}\u0082\1\0\0\0~\u0081\t\0\0\0\u0080~\1\0\0\0\u0081\u0084\1\0\0\0\u0082"+
		"\u0083\1\0\0\0\u0082\u0080\1\0\0\0\u0083\u0085\1\0\0\0\u0084\u0082\1\0"+
		"\0\0\u0085\u0086\5*\0\0\u0086\u0087\5/\0\0\u0087\u0088\1\0\0\0\u0088\u0089"+
		"\6\13\1\0\u0089\30\1\0\0\0\u008a\u008b\5/\0\0\u008b\u008c\5/\0\0\u008c"+
		"\u0091\1\0\0\0\u008d\u0090\b\1\0\0\u008f\u008d\1\0\0\0\u0090\u0093\1\0"+
		"\0\0\u0091\u008f\1\0\0\0\u0091\u0092\1\0\0\0\u0092\u0096\1\0\0\0\u0093"+
		"\u0091\1\0\0\0\u0094\u0097\5\r\0\0\u0096\u0094\1\0\0\0\u0096\u0097\1\0"+
		"\0\0\u0097\u0098\1\0\0\0\u0098\u009a\5\n\0\0\u009a\u009b\6\f\2\0\u009b"+
		"\32\1\0\0\0\t\0\1\62\1\64\1Q\1q\1w\1\u0082\0\u0091\1\u0096\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}