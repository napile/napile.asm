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
		T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, T__9=9, T__8=10, 
		T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, T__1=17, T__0=18, 
		Identifier=19, WS=20, COMMENT=21, LINE_COMMENT=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"']'", "')'", "'.'", "','", "'['", "':'", "'('", "'ref'", "'<'", "'var'", 
		"'?'", "'this'", "'{'", "'>'", "'val'", "'}'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", 
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
			case 0 : T__15_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__14_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__13_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__12_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__11_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__10_action((RuleContext)_localctx, actionIndex); break;
			case 6 : T__9_action((RuleContext)_localctx, actionIndex); break;
			case 7 : T__8_action((RuleContext)_localctx, actionIndex); break;
			case 8 : T__7_action((RuleContext)_localctx, actionIndex); break;
			case 9 : T__6_action((RuleContext)_localctx, actionIndex); break;
			case 10 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 11 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 12 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 13 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 14 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 15 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 16 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 17 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 18 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 19 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 20 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 21 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void WS_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 0 : _channel = HIDDEN; break;
		}
	}
	public void T__15_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 2 : _channel = HIDDEN; break;
		}
	}
	public void T__12_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__11_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__14_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__13_action(RuleContext _localctx, int actionIndex) {
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
	public void Letter_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__8_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Identifier_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__7_action(RuleContext _localctx, int actionIndex) {
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
		"\2\26\u00c6\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2"+
		"\6\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16"+
		"\7\16\2\17\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\2\25"+
		"\7\25\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\7\1\7"+
		"\1\7\1\7\1\b\1\b\1\t\1\t\1\t\1\t\1\n\1\n\1\13\1\13\1\13\1\13\1\13\1\f"+
		"\1\f\1\r\1\r\1\16\1\16\1\16\1\16\1\17\1\17\1\20\0\1\20\0\1\20\0\5\20\b"+
		"\20\n\20\f\20`\t\20\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1"+
		"\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\3\21\b\21\1\22\0\1\22\0\1\22"+
		"\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22\0\1\22"+
		"\0\1\22\0\1\22\0\3\22\b\22\1\23\0\4\23\b\23\13\23\f\23\u00a1\1\23\1\23"+
		"\1\24\1\24\1\24\1\24\0\5\24\b\24\n\24\f\24\u00ae\t\24\1\24\1\24\1\24\1"+
		"\24\1\24\1\25\1\25\1\25\1\25\0\5\25\b\25\n\25\f\25\u00bd\t\25\1\25\0\3"+
		"\25\b\25\1\25\0\1\25\1\25\26\1\3\uffff\3\4\uffff\5\5\uffff\7\6\uffff\t"+
		"\7\uffff\13\b\uffff\r\t\uffff\17\n\uffff\21\13\uffff\23\f\uffff\25\r\uffff"+
		"\27\16\uffff\31\17\uffff\33\20\uffff\35\21\uffff\37\22\uffff!\23\uffff"+
		"#\0\uffff%\0\uffff\'\24\0)\25\1+\26\2\1\0\2\3\t\n\f\r  \2\n\n\r\r\u00bf"+
		"\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0"+
		"\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0\0\0\0\23\1\0\0\0\0\25\1\0\0\0\0"+
		"\27\1\0\0\0\0\31\1\0\0\0\0\33\1\0\0\0\0\35\1\0\0\0\0\37\1\0\0\0\0!\1\0"+
		"\0\0\0\'\1\0\0\0\0)\1\0\0\0\0+\1\0\0\0\1-\1\0\0\0\3/\1\0\0\0\5\61\1\0"+
		"\0\0\7\63\1\0\0\0\t\65\1\0\0\0\13\67\1\0\0\0\r9\1\0\0\0\17;\1\0\0\0\21"+
		"?\1\0\0\0\23A\1\0\0\0\25E\1\0\0\0\27G\1\0\0\0\31L\1\0\0\0\33N\1\0\0\0"+
		"\35P\1\0\0\0\37T\1\0\0\0!V\1\0\0\0#{\1\0\0\0%\u009b\1\0\0\0\'\u009f\1"+
		"\0\0\0)\u00a5\1\0\0\0+\u00b4\1\0\0\0-.\5]\0\0.\2\1\0\0\0/\60\5)\0\0\60"+
		"\4\1\0\0\0\61\62\5.\0\0\62\6\1\0\0\0\63\64\5,\0\0\64\b\1\0\0\0\65\66\5"+
		"[\0\0\66\n\1\0\0\0\678\5:\0\08\f\1\0\0\09:\5(\0\0:\16\1\0\0\0;<\5r\0\0"+
		"<=\5e\0\0=>\5f\0\0>\20\1\0\0\0?@\5<\0\0@\22\1\0\0\0AB\5v\0\0BC\5a\0\0"+
		"CD\5r\0\0D\24\1\0\0\0EF\5?\0\0F\26\1\0\0\0GH\5t\0\0HI\5h\0\0IJ\5i\0\0"+
		"JK\5s\0\0K\30\1\0\0\0LM\5{\0\0M\32\1\0\0\0NO\5>\0\0O\34\1\0\0\0PQ\5v\0"+
		"\0QR\5a\0\0RS\5l\0\0S\36\1\0\0\0TU\5}\0\0U \1\0\0\0V^\3#\21\0X]\3#\21"+
		"\0Z]\3%\22\0\\X\1\0\0\0\\Z\1\0\0\0]`\1\0\0\0^\\\1\0\0\0^_\1\0\0\0_\"\1"+
		"\0\0\0`^\1\0\0\0a|\5$\0\0c|\2AZ\0e|\5_\0\0g|\2az\0i|\2\u00c0\u00d6\0k"+
		"|\2\u00d8\u00f6\0m|\2\u00f8\u00ff\0o|\2\u0100\u1fff\0q|\2\u3040\u318f"+
		"\0s|\2\u3300\u337f\0u|\2\u3400\u3d2d\0w|\2\u4e00\u9fff\0y|\2\uf900\ufaff"+
		"\0{a\1\0\0\0{c\1\0\0\0{e\1\0\0\0{g\1\0\0\0{i\1\0\0\0{k\1\0\0\0{m\1\0\0"+
		"\0{o\1\0\0\0{q\1\0\0\0{s\1\0\0\0{u\1\0\0\0{w\1\0\0\0{y\1\0\0\0|$\1\0\0"+
		"\0}\u009c\2\609\0\177\u009c\2\u0660\u0669\0\u0081\u009c\2\u06f0\u06f9"+
		"\0\u0083\u009c\2\u0966\u096f\0\u0085\u009c\2\u09e6\u09ef\0\u0087\u009c"+
		"\2\u0a66\u0a6f\0\u0089\u009c\2\u0ae6\u0aef\0\u008b\u009c\2\u0b66\u0b6f"+
		"\0\u008d\u009c\2\u0be7\u0bef\0\u008f\u009c\2\u0c66\u0c6f\0\u0091\u009c"+
		"\2\u0ce6\u0cef\0\u0093\u009c\2\u0d66\u0d6f\0\u0095\u009c\2\u0e50\u0e59"+
		"\0\u0097\u009c\2\u0ed0\u0ed9\0\u0099\u009c\2\u1040\u1049\0\u009b}\1\0"+
		"\0\0\u009b\177\1\0\0\0\u009b\u0081\1\0\0\0\u009b\u0083\1\0\0\0\u009b\u0085"+
		"\1\0\0\0\u009b\u0087\1\0\0\0\u009b\u0089\1\0\0\0\u009b\u008b\1\0\0\0\u009b"+
		"\u008d\1\0\0\0\u009b\u008f\1\0\0\0\u009b\u0091\1\0\0\0\u009b\u0093\1\0"+
		"\0\0\u009b\u0095\1\0\0\0\u009b\u0097\1\0\0\0\u009b\u0099\1\0\0\0\u009c"+
		"&\1\0\0\0\u009d\u00a0\7\0\0\0\u009f\u009d\1\0\0\0\u00a0\u00a1\1\0\0\0"+
		"\u00a1\u009f\1\0\0\0\u00a1\u00a2\1\0\0\0\u00a2\u00a3\1\0\0\0\u00a3\u00a4"+
		"\6\23\0\0\u00a4(\1\0\0\0\u00a5\u00a6\5/\0\0\u00a6\u00a7\5*\0\0\u00a7\u00ac"+
		"\1\0\0\0\u00a8\u00ab\t\0\0\0\u00aa\u00a8\1\0\0\0\u00ab\u00ae\1\0\0\0\u00ac"+
		"\u00ad\1\0\0\0\u00ac\u00aa\1\0\0\0\u00ad\u00af\1\0\0\0\u00ae\u00ac\1\0"+
		"\0\0\u00af\u00b0\5*\0\0\u00b0\u00b1\5/\0\0\u00b1\u00b2\1\0\0\0\u00b2\u00b3"+
		"\6\24\1\0\u00b3*\1\0\0\0\u00b4\u00b5\5/\0\0\u00b5\u00b6\5/\0\0\u00b6\u00bb"+
		"\1\0\0\0\u00b7\u00ba\b\1\0\0\u00b9\u00b7\1\0\0\0\u00ba\u00bd\1\0\0\0\u00bb"+
		"\u00b9\1\0\0\0\u00bb\u00bc\1\0\0\0\u00bc\u00c0\1\0\0\0\u00bd\u00bb\1\0"+
		"\0\0\u00be\u00c1\5\r\0\0\u00c0\u00be\1\0\0\0\u00c0\u00c1\1\0\0\0\u00c1"+
		"\u00c2\1\0\0\0\u00c2\u00c4\5\n\0\0\u00c4\u00c5\6\25\2\0\u00c5,\1\0\0\0"+
		"\t\0\1\\\1^\1{\1\u009b\1\u00a1\1\u00ac\0\u00bb\1\u00c0\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}