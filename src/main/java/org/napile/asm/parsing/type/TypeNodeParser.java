// $ANTLR ANTLRVersion> TypeNodeParser.java generatedTimestamp>

package org.napile.asm.parsing.type;

import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeParser extends Parser {
	public static final int
		T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Identifier=9, WS=10, COMMENT=11, 
		LINE_COMMENT=12;
	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'.'", "','", "'<'", "'?'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_typeNode = 0, RULE_arguments = 1, RULE_classOrThisType = 2, RULE_classType = 3, 
		RULE_nulled = 4, RULE_thisType = 5, RULE_qualifiedName = 6;
	public static final String[] ruleNames = {
		"typeNode", "arguments", "classOrThisType", "classType", "nulled", "thisType", 
		"qualifiedName"
	};

	@Override
	public String getGrammarFileName() { return "TypeNode.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public TypeNodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator<Token>(this,_ATN);
	}
	public static class TypeNodeContext extends ParserRuleContext<Token> {
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassOrThisTypeContext classOrThisType() {
		    return getRuleContext(ClassOrThisTypeContext.class,0);
		}
		public NulledContext nulled() {
		    return getRuleContext(NulledContext.class,0);
		}
		public TypeNodeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeNode; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterTypeNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitTypeNode(this);
		}
	}

	public final TypeNodeContext typeNode() throws RecognitionException {
		TypeNodeContext _localctx = new TypeNodeContext(_ctx, 0);
		enterRule(_localctx, RULE_typeNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); classOrThisType();
			setState(18);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==7 ) {
				{
				setState(16); arguments();
				}
			}

			setState(22);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==8 ) {
				{
				setState(20); nulled();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext<Token> {
		public List<? extends TypeNodeContext> typeNode() {
		    return getRuleContexts(TypeNodeContext.class);
		}
		public TypeNodeContext typeNode(int i) {
		    return getRuleContext(TypeNodeContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, 2);
		enterRule(_localctx, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(7);
			setState(26); typeNode();
			setState(32);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==6 ) {
				{
				setState(28); match(6);
				setState(30); typeNode();
				}
			}

			setState(34); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrThisTypeContext extends ParserRuleContext<Token> {
		public ThisTypeContext thisType() {
		    return getRuleContext(ThisTypeContext.class,0);
		}
		public ClassTypeContext classType() {
		    return getRuleContext(ClassTypeContext.class,0);
		}
		public ClassOrThisTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classOrThisType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterClassOrThisType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitClassOrThisType(this);
		}
	}

	public final ClassOrThisTypeContext classOrThisType() throws RecognitionException {
		ClassOrThisTypeContext _localctx = new ClassOrThisTypeContext(_ctx, 4);
		enterRule(_localctx, RULE_classOrThisType);
		try {
			setState(40);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(36); classType();
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 2);
					{
					setState(38); thisType();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTypeContext extends ParserRuleContext<Token> {
		public QualifiedNameContext qualifiedName() {
		    return getRuleContext(QualifiedNameContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitClassType(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, 6);
		enterRule(_localctx, RULE_classType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NulledContext extends ParserRuleContext<Token> {
		public NulledContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_nulled; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterNulled(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitNulled(this);
		}
	}

	public final NulledContext nulled() throws RecognitionException {
		NulledContext _localctx = new NulledContext(_ctx, 8);
		enterRule(_localctx, RULE_nulled);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThisTypeContext extends ParserRuleContext<Token> {
		public ThisTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_thisType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterThisType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitThisType(this);
		}
	}

	public final ThisTypeContext thisType() throws RecognitionException {
		ThisTypeContext _localctx = new ThisTypeContext(_ctx, 10);
		enterRule(_localctx, RULE_thisType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier(int i) {
		    return getToken(TypeNodeParser.Identifier, i);
		}
		public List<TerminalNode<Token>> Identifier() { return getTokens(TypeNodeParser.Identifier); }
		public QualifiedNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, 12);
		enterRule(_localctx, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(Identifier);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==5 ) {
				{
				{
				setState(50); match(5);
				setState(52); match(Identifier);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\f<\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6\1\0\0\1"+
		"\0\0\3\0\b\0\1\0\0\3\0\b\0\1\1\0\1\1\0\1\1\0\1\1\0\3\1\b\1\1\1\1\1\1\2"+
		"\0\1\2\0\3\2\b\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\0\1\6\0\1\6\0\5\6\b\6\n\6"+
		"\f\6:\t\6\1\6\7\0\2\4\6\b\n\f\0\0\65\0\16\1\0\0\0\1 \1\0\0\0\1!\1\0\0"+
		"\0\2\30\1\0\0\0\3\23\1\0\0\0\4(\1\0\0\0\5\22\1\0\0\0\6*\1\0\0\0\7)\1\0"+
		"\0\0\b,\1\0\0\0\t\27\1\0\0\0\n.\1\0\0\0\13)\1\0\0\0\f\60\1\0\0\0\r+\1"+
		"\0\0\0\16\22\3\4\2\0\20\23\3\2\1\0\22\20\1\0\0\0\22\23\1\0\0\0\23\26\1"+
		"\0\0\0\24\27\3\b\4\0\26\24\1\0\0\0\26\27\1\0\0\0\27\1\1\0\0\0\30\32\5"+
		"\7\0\0\32 \3\0\0\0\34\36\5\6\0\0\36!\3\0\0\0 \34\1\0\0\0 !\1\0\0\0!\""+
		"\1\0\0\0\"#\5\4\0\0#\3\1\0\0\0$)\3\6\3\0&)\3\n\5\0($\1\0\0\0(&\1\0\0\0"+
		")\5\1\0\0\0*+\3\f\6\0+\7\1\0\0\0,-\5\b\0\0-\t\1\0\0\0./\5\3\0\0/\13\1"+
		"\0\0\0\608\5\t\0\0\62\64\5\5\0\0\64\67\5\t\0\0\66\62\1\0\0\0\67:\1\0\0"+
		"\08\66\1\0\0\089\1\0\0\09\r\1\0\0\0:8\1\0\0\0\5\22\1\26\1 \1(\18\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}