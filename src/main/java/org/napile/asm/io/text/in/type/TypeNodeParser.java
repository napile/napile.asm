// $ANTLR ANTLRVersion> TypeNodeParser.java generatedTimestamp>

package org.napile.asm.io.text.in.type;

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
		T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, T__3=10, T__2=11, 
		T__1=12, T__0=13, Identifier=14, WS=15, COMMENT=16, LINE_COMMENT=17;
	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'this'", "'>'", "'{'", "')'", "'.'", "','", "'('", "':'", "'<'", "'}'", 
		"'?'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_typeNode = 0, RULE_arguments = 1, RULE_typePart = 2, RULE_classType = 3, 
		RULE_thisType = 4, RULE_methodType = 5, RULE_methodParameter = 6, RULE_returnType = 7, 
		RULE_typeParameterValue = 8, RULE_nulled = 9, RULE_qualifiedName = 10;
	public static final String[] ruleNames = {
		"typeNode", "arguments", "typePart", "classType", "thisType", "methodType", 
		"methodParameter", "returnType", "typeParameterValue", "nulled", "qualifiedName"
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
		public TypePartContext typePart() {
		    return getRuleContext(TypePartContext.class,0);
		}
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
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
			setState(22); typePart();
			setState(26);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==11 ) {
				{
				setState(24); arguments();
				}
			}

			setState(30);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==13 ) {
				{
				setState(28); nulled();
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
			setState(32); match(11);
			setState(34); typeNode();
			setState(40);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==8 ) {
				{
				setState(36); match(8);
				setState(38); typeNode();
				}
			}

			setState(42); match(4);
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

	public static class TypePartContext extends ParserRuleContext<Token> {
		public ThisTypeContext thisType() {
		    return getRuleContext(ThisTypeContext.class,0);
		}
		public TypeParameterValueContext typeParameterValue() {
		    return getRuleContext(TypeParameterValueContext.class,0);
		}
		public MethodTypeContext methodType() {
		    return getRuleContext(MethodTypeContext.class,0);
		}
		public ClassTypeContext classType() {
		    return getRuleContext(ClassTypeContext.class,0);
		}
		public TypePartContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typePart; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterTypePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitTypePart(this);
		}
	}

	public final TypePartContext typePart() throws RecognitionException {
		TypePartContext _localctx = new TypePartContext(_ctx, 4);
		enterRule(_localctx, RULE_typePart);
		try {
			setState(52);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(44); classType();
					}
					break;
				case 10:
					enterOuterAlt(_localctx, 2);
					{
					setState(46); typeParameterValue();
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(48); thisType();
					}
					break;
				case 5:
					enterOuterAlt(_localctx, 4);
					{
					setState(50); methodType();
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
			setState(54); qualifiedName();
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
		ThisTypeContext _localctx = new ThisTypeContext(_ctx, 8);
		enterRule(_localctx, RULE_thisType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(3);
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

	public static class MethodTypeContext extends ParserRuleContext<Token> {
		public List<? extends MethodParameterContext> methodParameter() {
		    return getRuleContexts(MethodParameterContext.class);
		}
		public MethodParameterContext methodParameter(int i) {
		    return getRuleContext(MethodParameterContext.class,i);
		}
		public ReturnTypeContext returnType() {
		    return getRuleContext(ReturnTypeContext.class,0);
		}
		public MethodTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitMethodType(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, 10);
		enterRule(_localctx, RULE_methodType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(5);
			setState(60); match(9);
			setState(62); methodParameter();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==8 ) {
				{
				{
				setState(64); match(8);
				setState(66); methodParameter();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); match(6);
			setState(75); match(10);
			setState(77); returnType();
			setState(79); match(12);
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

	public static class MethodParameterContext extends ParserRuleContext<Token> {
		public TypeNodeContext typeNode() {
		    return getRuleContext(TypeNodeContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(TypeNodeParser.Identifier, 0); }
		public MethodParameterContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_methodParameter; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterMethodParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitMethodParameter(this);
		}
	}

	public final MethodParameterContext methodParameter() throws RecognitionException {
		MethodParameterContext _localctx = new MethodParameterContext(_ctx, 12);
		enterRule(_localctx, RULE_methodParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(Identifier);
			setState(83); match(10);
			setState(85); typeNode();
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

	public static class ReturnTypeContext extends ParserRuleContext<Token> {
		public TypeNodeContext typeNode() {
		    return getRuleContext(TypeNodeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, 14);
		enterRule(_localctx, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); typeNode();
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

	public static class TypeParameterValueContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier() { return getToken(TypeNodeParser.Identifier, 0); }
		public TypeParameterValueContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterValue; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterTypeParameterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitTypeParameterValue(this);
		}
	}

	public final TypeParameterValueContext typeParameterValue() throws RecognitionException {
		TypeParameterValueContext _localctx = new TypeParameterValueContext(_ctx, 16);
		enterRule(_localctx, RULE_typeParameterValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(10);
			setState(91); match(Identifier);
			setState(93); match(10);
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
		NulledContext _localctx = new NulledContext(_ctx, 18);
		enterRule(_localctx, RULE_nulled);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(13);
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
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, 20);
		enterRule(_localctx, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(Identifier);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==7 ) {
				{
				{
				setState(99); match(7);
				setState(101); match(Identifier);
				}
				}
				setState(107);
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
		"\3\21m\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6\2\7\7\7"+
		"\2\b\7\b\2\t\7\t\2\n\7\n\1\0\0\1\0\0\3\0\b\0\1\0\0\3\0\b\0\1\1\0\1\1\0"+
		"\1\1\0\1\1\0\3\1\b\1\1\1\1\1\1\2\0\1\2\0\1\2\0\1\2\0\3\2\b\2\1\3\1\3\1"+
		"\4\1\4\1\5\0\1\5\0\1\5\0\1\5\0\1\5\0\5\5\b\5\n\5\f\5H\t\5\1\5\0\1\5\0"+
		"\1\5\0\1\5\1\5\1\6\0\1\6\0\1\6\1\6\1\7\1\7\1\b\0\1\b\0\1\b\1\b\1\t\1\t"+
		"\1\n\0\1\n\0\1\n\0\5\n\b\n\n\n\f\nk\t\n\1\n\13\0\2\4\6\b\n\f\16\20\22"+
		"\24\0\0^\0\26\1\0\0\0\1(\1\0\0\0\1)\1\0\0\0\1V\1\0\0\0\1X\1\0\0\0\2 \1"+
		"\0\0\0\3\33\1\0\0\0\4\64\1\0\0\0\5\32\1\0\0\0\6\66\1\0\0\0\7\65\1\0\0"+
		"\0\b8\1\0\0\0\t\65\1\0\0\0\n:\1\0\0\0\13\65\1\0\0\0\fQ\1\0\0\0\rF\1\0"+
		"\0\0\rE\1\0\0\0\16W\1\0\0\0\17O\1\0\0\0\20Y\1\0\0\0\21\65\1\0\0\0\22_"+
		"\1\0\0\0\23\37\1\0\0\0\24a\1\0\0\0\25\67\1\0\0\0\26\32\3\4\2\0\30\33\3"+
		"\2\1\0\32\30\1\0\0\0\32\33\1\0\0\0\33\36\1\0\0\0\34\37\3\22\t\0\36\34"+
		"\1\0\0\0\36\37\1\0\0\0\37\1\1\0\0\0 \"\5\13\0\0\"(\3\0\0\0$&\5\b\0\0&"+
		")\3\0\0\0($\1\0\0\0()\1\0\0\0)*\1\0\0\0*+\5\4\0\0+\3\1\0\0\0,\65\3\6\3"+
		"\0.\65\3\20\b\0\60\65\3\b\4\0\62\65\3\n\5\0\64,\1\0\0\0\64.\1\0\0\0\64"+
		"\60\1\0\0\0\64\62\1\0\0\0\65\5\1\0\0\0\66\67\3\24\n\0\67\7\1\0\0\089\5"+
		"\3\0\09\t\1\0\0\0:<\5\5\0\0<>\5\t\0\0>F\3\f\6\0@B\5\b\0\0BE\3\f\6\0D@"+
		"\1\0\0\0EH\1\0\0\0FD\1\0\0\0FG\1\0\0\0GI\1\0\0\0HF\1\0\0\0IK\5\6\0\0K"+
		"M\5\n\0\0MO\3\16\7\0OP\5\f\0\0P\13\1\0\0\0QS\5\16\0\0SU\5\n\0\0UV\3\0"+
		"\0\0V\r\1\0\0\0WX\3\0\0\0X\17\1\0\0\0Y[\5\n\0\0[]\5\16\0\0]^\5\n\0\0^"+
		"\21\1\0\0\0_`\5\r\0\0`\23\1\0\0\0ai\5\16\0\0ce\5\7\0\0eh\5\16\0\0gc\1"+
		"\0\0\0hk\1\0\0\0ig\1\0\0\0ij\1\0\0\0j\25\1\0\0\0ki\1\0\0\0\6\32\1\36\1"+
		"(\1\64\1F\1i\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}