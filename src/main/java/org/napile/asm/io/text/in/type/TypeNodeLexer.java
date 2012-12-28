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
		T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, T__8=9, T__7=10, 
		T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, T__0=17, Identifier=18, 
		WS=19, COMMENT=20, LINE_COMMENT=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"']'", "')'", "'.'", "','", "'['", "':'", "'('", "'<'", "'var'", "'?'", 
		"'this'", "'{'", "'>'", "'val'", "'}'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", "Letter", 
		"JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT"
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
			case 0 : T__14_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__13_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__12_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__11_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__10_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__9_action((RuleContext)_localctx, actionIndex); break;
			case 6 : T__8_action((RuleContext)_localctx, actionIndex); break;
			case 7 : T__7_action((RuleContext)_localctx, actionIndex); break;
			case 8 : T__6_action((RuleContext)_localctx, actionIndex); break;
			case 9 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 10 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 11 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 12 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 13 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 14 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 15 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 16 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 17 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 18 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 19 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 20 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\25\u00c0\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2"+
		"\6\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16"+
		"\7\16\2\17\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\1\0"+
		"\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\7\1\7\1\b\1\b\1"+
		"\b\1\b\1\t\1\t\1\n\1\n\1\n\1\n\1\n\1\13\1\13\1\f\1\f\1\r\1\r\1\r\1\r\1"+
		"\16\1\16\1\17\0\1\17\0\1\17\0\5\17\b\17\n\17\f\17Z\t\17\1\20\0\1\20\0"+
		"\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0\1\20\0"+
		"\1\20\0\3\20\b\20\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21"+
		"\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\1\21\0\3\21\b\21\1\22\0\4"+
		"\22\b\22\13\22\f\22\u009b\1\22\1\22\1\23\1\23\1\23\1\23\0\5\23\b\23\n"+
		"\23\f\23\u00a8\t\23\1\23\1\23\1\23\1\23\1\23\1\24\1\24\1\24\1\24\0\5\24"+
		"\b\24\n\24\f\24\u00b7\t\24\1\24\0\3\24\b\24\1\24\0\1\24\1\24\25\1\3\uffff"+
		"\3\4\uffff\5\5\uffff\7\6\uffff\t\7\uffff\13\b\uffff\r\t\uffff\17\n\uffff"+
		"\21\13\uffff\23\f\uffff\25\r\uffff\27\16\uffff\31\17\uffff\33\20\uffff"+
		"\35\21\uffff\37\22\uffff!\0\uffff#\0\uffff%\23\0\'\24\1)\25\2\1\0\2\3"+
		"\t\n\f\r  \2\n\n\r\r\u00b9\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0\7\1\0"+
		"\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0\0\0\0"+
		"\23\1\0\0\0\0\25\1\0\0\0\0\27\1\0\0\0\0\31\1\0\0\0\0\33\1\0\0\0\0\35\1"+
		"\0\0\0\0\37\1\0\0\0\0%\1\0\0\0\0\'\1\0\0\0\0)\1\0\0\0\1+\1\0\0\0\3-\1"+
		"\0\0\0\5/\1\0\0\0\7\61\1\0\0\0\t\63\1\0\0\0\13\65\1\0\0\0\r\67\1\0\0\0"+
		"\179\1\0\0\0\21;\1\0\0\0\23?\1\0\0\0\25A\1\0\0\0\27F\1\0\0\0\31H\1\0\0"+
		"\0\33J\1\0\0\0\35N\1\0\0\0\37P\1\0\0\0!u\1\0\0\0#\u0095\1\0\0\0%\u0099"+
		"\1\0\0\0\'\u009f\1\0\0\0)\u00ae\1\0\0\0+,\5]\0\0,\2\1\0\0\0-.\5)\0\0."+
		"\4\1\0\0\0/\60\5.\0\0\60\6\1\0\0\0\61\62\5,\0\0\62\b\1\0\0\0\63\64\5["+
		"\0\0\64\n\1\0\0\0\65\66\5:\0\0\66\f\1\0\0\0\678\5(\0\08\16\1\0\0\09:\5"+
		"<\0\0:\20\1\0\0\0;<\5v\0\0<=\5a\0\0=>\5r\0\0>\22\1\0\0\0?@\5?\0\0@\24"+
		"\1\0\0\0AB\5t\0\0BC\5h\0\0CD\5i\0\0DE\5s\0\0E\26\1\0\0\0FG\5{\0\0G\30"+
		"\1\0\0\0HI\5>\0\0I\32\1\0\0\0JK\5v\0\0KL\5a\0\0LM\5l\0\0M\34\1\0\0\0N"+
		"O\5}\0\0O\36\1\0\0\0PX\3!\20\0RW\3!\20\0TW\3#\21\0VR\1\0\0\0VT\1\0\0\0"+
		"WZ\1\0\0\0XV\1\0\0\0XY\1\0\0\0Y \1\0\0\0ZX\1\0\0\0[v\5$\0\0]v\2AZ\0_v"+
		"\5_\0\0av\2az\0cv\2\u00c0\u00d6\0ev\2\u00d8\u00f6\0gv\2\u00f8\u00ff\0"+
		"iv\2\u0100\u1fff\0kv\2\u3040\u318f\0mv\2\u3300\u337f\0ov\2\u3400\u3d2d"+
		"\0qv\2\u4e00\u9fff\0sv\2\uf900\ufaff\0u[\1\0\0\0u]\1\0\0\0u_\1\0\0\0u"+
		"a\1\0\0\0uc\1\0\0\0ue\1\0\0\0ug\1\0\0\0ui\1\0\0\0uk\1\0\0\0um\1\0\0\0"+
		"uo\1\0\0\0uq\1\0\0\0us\1\0\0\0v\"\1\0\0\0w\u0096\2\609\0y\u0096\2\u0660"+
		"\u0669\0{\u0096\2\u06f0\u06f9\0}\u0096\2\u0966\u096f\0\177\u0096\2\u09e6"+
		"\u09ef\0\u0081\u0096\2\u0a66\u0a6f\0\u0083\u0096\2\u0ae6\u0aef\0\u0085"+
		"\u0096\2\u0b66\u0b6f\0\u0087\u0096\2\u0be7\u0bef\0\u0089\u0096\2\u0c66"+
		"\u0c6f\0\u008b\u0096\2\u0ce6\u0cef\0\u008d\u0096\2\u0d66\u0d6f\0\u008f"+
		"\u0096\2\u0e50\u0e59\0\u0091\u0096\2\u0ed0\u0ed9\0\u0093\u0096\2\u1040"+
		"\u1049\0\u0095w\1\0\0\0\u0095y\1\0\0\0\u0095{\1\0\0\0\u0095}\1\0\0\0\u0095"+
		"\177\1\0\0\0\u0095\u0081\1\0\0\0\u0095\u0083\1\0\0\0\u0095\u0085\1\0\0"+
		"\0\u0095\u0087\1\0\0\0\u0095\u0089\1\0\0\0\u0095\u008b\1\0\0\0\u0095\u008d"+
		"\1\0\0\0\u0095\u008f\1\0\0\0\u0095\u0091\1\0\0\0\u0095\u0093\1\0\0\0\u0096"+
		"$\1\0\0\0\u0097\u009a\7\0\0\0\u0099\u0097\1\0\0\0\u009a\u009b\1\0\0\0"+
		"\u009b\u0099\1\0\0\0\u009b\u009c\1\0\0\0\u009c\u009d\1\0\0\0\u009d\u009e"+
		"\6\22\0\0\u009e&\1\0\0\0\u009f\u00a0\5/\0\0\u00a0\u00a1\5*\0\0\u00a1\u00a6"+
		"\1\0\0\0\u00a2\u00a5\t\0\0\0\u00a4\u00a2\1\0\0\0\u00a5\u00a8\1\0\0\0\u00a6"+
		"\u00a7\1\0\0\0\u00a6\u00a4\1\0\0\0\u00a7\u00a9\1\0\0\0\u00a8\u00a6\1\0"+
		"\0\0\u00a9\u00aa\5*\0\0\u00aa\u00ab\5/\0\0\u00ab\u00ac\1\0\0\0\u00ac\u00ad"+
		"\6\23\1\0\u00ad(\1\0\0\0\u00ae\u00af\5/\0\0\u00af\u00b0\5/\0\0\u00b0\u00b5"+
		"\1\0\0\0\u00b1\u00b4\b\1\0\0\u00b3\u00b1\1\0\0\0\u00b4\u00b7\1\0\0\0\u00b5"+
		"\u00b3\1\0\0\0\u00b5\u00b6\1\0\0\0\u00b6\u00ba\1\0\0\0\u00b7\u00b5\1\0"+
		"\0\0\u00b8\u00bb\5\r\0\0\u00ba\u00b8\1\0\0\0\u00ba\u00bb\1\0\0\0\u00bb"+
		"\u00bc\1\0\0\0\u00bc\u00be\5\n\0\0\u00be\u00bf\6\24\2\0\u00bf*\1\0\0\0"+
		"\t\0\1V\1X\1u\1\u0095\1\u009b\1\u00a6\0\u00b5\1\u00ba\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}