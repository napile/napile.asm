// $ANTLR ANTLRVersion> TypeNodeLexer.java generatedTimestamp>

package org.napile.asm.parsing.type;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeLexer extends Lexer {
	public static final int
		T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Identifier=9, WS=10, COMMENT=11, 
		LINE_COMMENT=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'.'", "','", "'<'", "'?'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
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
			case 0 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 6 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 7 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 8 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 9 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 10 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 11 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void JavaIDDigit_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
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
		"\2\f\u0098\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6"+
		"\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\1\0\1\0\1\0\1\0\1\0\1\1"+
		"\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\0\1\6\0\1\6\0\5\6\b\6\n\6\f\6"+
		"\62\t\6\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1\7\0\1"+
		"\7\0\1\7\0\1\7\0\3\7\b\7\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b"+
		"\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\1\b\0\3\b\b\b\1\t\0\4\t\b\t\13"+
		"\t\f\ts\1\t\1\t\1\n\1\n\1\n\1\n\0\5\n\b\n\n\n\f\n\u0080\t\n\1\n\1\n\1"+
		"\n\1\n\1\n\1\13\1\13\1\13\1\13\0\5\13\b\13\n\13\f\13\u008f\t\13\1\13\0"+
		"\3\13\b\13\1\13\0\1\13\1\13\f\1\3\uffff\3\4\uffff\5\5\uffff\7\6\uffff"+
		"\t\7\uffff\13\b\uffff\r\t\uffff\17\0\uffff\21\0\uffff\23\n\0\25\13\1\27"+
		"\f\2\1\0\2\3\t\n\f\r  \2\n\n\r\r\u0091\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0"+
		"\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\0\23\1\0\0\0\0\25"+
		"\1\0\0\0\0\27\1\0\0\0\1\31\1\0\0\0\3\36\1\0\0\0\5 \1\0\0\0\7\"\1\0\0\0"+
		"\t$\1\0\0\0\13&\1\0\0\0\r(\1\0\0\0\17M\1\0\0\0\21m\1\0\0\0\23q\1\0\0\0"+
		"\25w\1\0\0\0\27\u0086\1\0\0\0\31\32\5t\0\0\32\33\5h\0\0\33\34\5i\0\0\34"+
		"\35\5s\0\0\35\2\1\0\0\0\36\37\5>\0\0\37\4\1\0\0\0 !\5.\0\0!\6\1\0\0\0"+
		"\"#\5,\0\0#\b\1\0\0\0$%\5<\0\0%\n\1\0\0\0&\'\5?\0\0\'\f\1\0\0\0(\60\3"+
		"\17\7\0*/\3\17\7\0,/\3\21\b\0.*\1\0\0\0.,\1\0\0\0/\62\1\0\0\0\60.\1\0"+
		"\0\0\60\61\1\0\0\0\61\16\1\0\0\0\62\60\1\0\0\0\63N\5$\0\0\65N\2AZ\0\67"+
		"N\5_\0\09N\2az\0;N\2\u00c0\u00d6\0=N\2\u00d8\u00f6\0?N\2\u00f8\u00ff\0"+
		"AN\2\u0100\u1fff\0CN\2\u3040\u318f\0EN\2\u3300\u337f\0GN\2\u3400\u3d2d"+
		"\0IN\2\u4e00\u9fff\0KN\2\uf900\ufaff\0M\63\1\0\0\0M\65\1\0\0\0M\67\1\0"+
		"\0\0M9\1\0\0\0M;\1\0\0\0M=\1\0\0\0M?\1\0\0\0MA\1\0\0\0MC\1\0\0\0ME\1\0"+
		"\0\0MG\1\0\0\0MI\1\0\0\0MK\1\0\0\0N\20\1\0\0\0On\2\609\0Qn\2\u0660\u0669"+
		"\0Sn\2\u06f0\u06f9\0Un\2\u0966\u096f\0Wn\2\u09e6\u09ef\0Yn\2\u0a66\u0a6f"+
		"\0[n\2\u0ae6\u0aef\0]n\2\u0b66\u0b6f\0_n\2\u0be7\u0bef\0an\2\u0c66\u0c6f"+
		"\0cn\2\u0ce6\u0cef\0en\2\u0d66\u0d6f\0gn\2\u0e50\u0e59\0in\2\u0ed0\u0ed9"+
		"\0kn\2\u1040\u1049\0mO\1\0\0\0mQ\1\0\0\0mS\1\0\0\0mU\1\0\0\0mW\1\0\0\0"+
		"mY\1\0\0\0m[\1\0\0\0m]\1\0\0\0m_\1\0\0\0ma\1\0\0\0mc\1\0\0\0me\1\0\0\0"+
		"mg\1\0\0\0mi\1\0\0\0mk\1\0\0\0n\22\1\0\0\0or\7\0\0\0qo\1\0\0\0rs\1\0\0"+
		"\0sq\1\0\0\0st\1\0\0\0tu\1\0\0\0uv\6\t\0\0v\24\1\0\0\0wx\5/\0\0xy\5*\0"+
		"\0y~\1\0\0\0z}\t\0\0\0|z\1\0\0\0}\u0080\1\0\0\0~\177\1\0\0\0~|\1\0\0\0"+
		"\177\u0081\1\0\0\0\u0080~\1\0\0\0\u0081\u0082\5*\0\0\u0082\u0083\5/\0"+
		"\0\u0083\u0084\1\0\0\0\u0084\u0085\6\n\1\0\u0085\26\1\0\0\0\u0086\u0087"+
		"\5/\0\0\u0087\u0088\5/\0\0\u0088\u008d\1\0\0\0\u0089\u008c\b\1\0\0\u008b"+
		"\u0089\1\0\0\0\u008c\u008f\1\0\0\0\u008d\u008b\1\0\0\0\u008d\u008e\1\0"+
		"\0\0\u008e\u0092\1\0\0\0\u008f\u008d\1\0\0\0\u0090\u0093\5\r\0\0\u0092"+
		"\u0090\1\0\0\0\u0092\u0093\1\0\0\0\u0093\u0094\1\0\0\0\u0094\u0096\5\n"+
		"\0\0\u0096\u0097\6\13\2\0\u0097\30\1\0\0\0\t\0\1.\1\60\1M\1m\1s\1~\0\u008d"+
		"\1\u0092\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}