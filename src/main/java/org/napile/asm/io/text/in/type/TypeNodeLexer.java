// $ANTLR ANTLRVersion> TypeNodeLexer.java generatedTimestamp>

package org.napile.asm.io.text.in.type;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeLexer extends Lexer {
	public static final int
		T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, T__3=10, T__2=11, 
		T__1=12, T__0=13, Identifier=14, WS=15, COMMENT=16, LINE_COMMENT=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'{'", "')'", "'.'", "','", "'('", "':'", "'<'", "'}'", 
		"'?'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "Identifier", "Letter", "JavaIDDigit", "WS", "COMMENT", 
		"LINE_COMMENT"
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
			case 0 : T__10_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__9_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__8_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__7_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__6_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 6 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 7 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 8 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 9 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 10 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 11 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 12 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 13 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 14 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 15 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 16 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
	public void T__10_action(RuleContext _localctx, int actionIndex) {
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
	public void T__9_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__8_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Letter_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__7_action(RuleContext _localctx, int actionIndex) {
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
		"\2\21\u00ac\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2"+
		"\6\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16"+
		"\7\16\2\17\7\17\2\20\7\20\1\0\1\0\1\0\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3"+
		"\1\4\1\4\1\5\1\5\1\6\1\6\1\7\1\7\1\b\1\b\1\t\1\t\1\n\1\n\1\13\0\1\13\0"+
		"\1\13\0\5\13\b\13\n\13\f\13F\t\13\1\f\0\1\f\0\1\f\0\1\f\0\1\f\0\1\f\0"+
		"\1\f\0\1\f\0\1\f\0\1\f\0\1\f\0\1\f\0\1\f\0\3\f\b\f\1\r\0\1\r\0\1\r\0\1"+
		"\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0\1\r\0"+
		"\3\r\b\r\1\16\0\4\16\b\16\13\16\f\16\u0087\1\16\1\16\1\17\1\17\1\17\1"+
		"\17\0\5\17\b\17\n\17\f\17\u0094\t\17\1\17\1\17\1\17\1\17\1\17\1\20\1\20"+
		"\1\20\1\20\0\5\20\b\20\n\20\f\20\u00a3\t\20\1\20\0\3\20\b\20\1\20\0\1"+
		"\20\1\20\21\1\3\uffff\3\4\uffff\5\5\uffff\7\6\uffff\t\7\uffff\13\b\uffff"+
		"\r\t\uffff\17\n\uffff\21\13\uffff\23\f\uffff\25\r\uffff\27\16\uffff\31"+
		"\0\uffff\33\0\uffff\35\17\0\37\20\1!\21\2\1\0\2\3\t\n\f\r  \2\n\n\r\r"+
		"\u00a5\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13"+
		"\1\0\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0\0\0\0\23\1\0\0\0\0\25\1\0\0"+
		"\0\0\27\1\0\0\0\0\35\1\0\0\0\0\37\1\0\0\0\0!\1\0\0\0\1#\1\0\0\0\3(\1\0"+
		"\0\0\5*\1\0\0\0\7,\1\0\0\0\t.\1\0\0\0\13\60\1\0\0\0\r\62\1\0\0\0\17\64"+
		"\1\0\0\0\21\66\1\0\0\0\238\1\0\0\0\25:\1\0\0\0\27<\1\0\0\0\31a\1\0\0\0"+
		"\33\u0081\1\0\0\0\35\u0085\1\0\0\0\37\u008b\1\0\0\0!\u009a\1\0\0\0#$\5"+
		"t\0\0$%\5h\0\0%&\5i\0\0&\'\5s\0\0\'\2\1\0\0\0()\5>\0\0)\4\1\0\0\0*+\5"+
		"{\0\0+\6\1\0\0\0,-\5)\0\0-\b\1\0\0\0./\5.\0\0/\n\1\0\0\0\60\61\5,\0\0"+
		"\61\f\1\0\0\0\62\63\5(\0\0\63\16\1\0\0\0\64\65\5:\0\0\65\20\1\0\0\0\66"+
		"\67\5<\0\0\67\22\1\0\0\089\5}\0\09\24\1\0\0\0:;\5?\0\0;\26\1\0\0\0<D\3"+
		"\31\f\0>C\3\31\f\0@C\3\33\r\0B>\1\0\0\0B@\1\0\0\0CF\1\0\0\0DB\1\0\0\0"+
		"DE\1\0\0\0E\30\1\0\0\0FD\1\0\0\0Gb\5$\0\0Ib\2AZ\0Kb\5_\0\0Mb\2az\0Ob\2"+
		"\u00c0\u00d6\0Qb\2\u00d8\u00f6\0Sb\2\u00f8\u00ff\0Ub\2\u0100\u1fff\0W"+
		"b\2\u3040\u318f\0Yb\2\u3300\u337f\0[b\2\u3400\u3d2d\0]b\2\u4e00\u9fff"+
		"\0_b\2\uf900\ufaff\0aG\1\0\0\0aI\1\0\0\0aK\1\0\0\0aM\1\0\0\0aO\1\0\0\0"+
		"aQ\1\0\0\0aS\1\0\0\0aU\1\0\0\0aW\1\0\0\0aY\1\0\0\0a[\1\0\0\0a]\1\0\0\0"+
		"a_\1\0\0\0b\32\1\0\0\0c\u0082\2\609\0e\u0082\2\u0660\u0669\0g\u0082\2"+
		"\u06f0\u06f9\0i\u0082\2\u0966\u096f\0k\u0082\2\u09e6\u09ef\0m\u0082\2"+
		"\u0a66\u0a6f\0o\u0082\2\u0ae6\u0aef\0q\u0082\2\u0b66\u0b6f\0s\u0082\2"+
		"\u0be7\u0bef\0u\u0082\2\u0c66\u0c6f\0w\u0082\2\u0ce6\u0cef\0y\u0082\2"+
		"\u0d66\u0d6f\0{\u0082\2\u0e50\u0e59\0}\u0082\2\u0ed0\u0ed9\0\177\u0082"+
		"\2\u1040\u1049\0\u0081c\1\0\0\0\u0081e\1\0\0\0\u0081g\1\0\0\0\u0081i\1"+
		"\0\0\0\u0081k\1\0\0\0\u0081m\1\0\0\0\u0081o\1\0\0\0\u0081q\1\0\0\0\u0081"+
		"s\1\0\0\0\u0081u\1\0\0\0\u0081w\1\0\0\0\u0081y\1\0\0\0\u0081{\1\0\0\0"+
		"\u0081}\1\0\0\0\u0081\177\1\0\0\0\u0082\34\1\0\0\0\u0083\u0086\7\0\0\0"+
		"\u0085\u0083\1\0\0\0\u0086\u0087\1\0\0\0\u0087\u0085\1\0\0\0\u0087\u0088"+
		"\1\0\0\0\u0088\u0089\1\0\0\0\u0089\u008a\6\16\0\0\u008a\36\1\0\0\0\u008b"+
		"\u008c\5/\0\0\u008c\u008d\5*\0\0\u008d\u0092\1\0\0\0\u008e\u0091\t\0\0"+
		"\0\u0090\u008e\1\0\0\0\u0091\u0094\1\0\0\0\u0092\u0093\1\0\0\0\u0092\u0090"+
		"\1\0\0\0\u0093\u0095\1\0\0\0\u0094\u0092\1\0\0\0\u0095\u0096\5*\0\0\u0096"+
		"\u0097\5/\0\0\u0097\u0098\1\0\0\0\u0098\u0099\6\17\1\0\u0099 \1\0\0\0"+
		"\u009a\u009b\5/\0\0\u009b\u009c\5/\0\0\u009c\u00a1\1\0\0\0\u009d\u00a0"+
		"\b\1\0\0\u009f\u009d\1\0\0\0\u00a0\u00a3\1\0\0\0\u00a1\u009f\1\0\0\0\u00a1"+
		"\u00a2\1\0\0\0\u00a2\u00a6\1\0\0\0\u00a3\u00a1\1\0\0\0\u00a4\u00a7\5\r"+
		"\0\0\u00a6\u00a4\1\0\0\0\u00a6\u00a7\1\0\0\0\u00a7\u00a8\1\0\0\0\u00a8"+
		"\u00aa\5\n\0\0\u00aa\u00ab\6\20\2\0\u00ab\"\1\0\0\0\t\0\1B\1D\1a\1\u0081"+
		"\1\u0087\1\u0092\0\u00a1\1\u00a6\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}