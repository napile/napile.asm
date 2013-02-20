// $ANTLR ANTLRVersion> TypeNodeParser.java generatedTimestamp>

package org.napile.asm.io.text.in.type;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeNodeParser extends Parser {
	public static final int
		T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, T__9=9, T__8=10, 
		T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, T__1=17, T__0=18, 
		Identifier=19, WS=20, COMMENT=21, LINE_COMMENT=22;
	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"']'", "')'", "'.'", "','", "'['", "':'", "'('", "'ref'", "'<'", "'var'", 
		"'?'", "'this'", "'{'", "'>'", "'val'", "'}'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_typeNode = 0, RULE_arguments = 1, RULE_typePart = 2, RULE_classType = 3, 
		RULE_thisType = 4, RULE_methodType = 5, RULE_methodParameter = 6, RULE_returnType = 7, 
		RULE_multiType = 8, RULE_multiTypeEntry = 9, RULE_typeParameterValue = 10, 
		RULE_varOrValOrRef = 11, RULE_nulled = 12, RULE_qualifiedName = 13;
	public static final String[] ruleNames = {
		"typeNode", "arguments", "typePart", "classType", "thisType", "methodType", 
		"methodParameter", "returnType", "multiType", "multiTypeEntry", "typeParameterValue", 
		"varOrValOrRef", "nulled", "qualifiedName"
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
			setState(28); typePart();
			setState(32);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==11 ) {
				{
				setState(30); arguments();
				}
			}

			setState(36);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==13 ) {
				{
				setState(34); nulled();
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
			setState(38); match(11);
			setState(40); typeNode();
			setState(46);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==6 ) {
				{
				setState(42); match(6);
				setState(44); typeNode();
				}
			}

			setState(48); match(16);
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
		public MultiTypeContext multiType() {
		    return getRuleContext(MultiTypeContext.class,0);
		}
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
			setState(60);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(50); classType();
					}
					break;
				case 8:
					enterOuterAlt(_localctx, 2);
					{
					setState(52); typeParameterValue();
					}
					break;
				case 14:
					enterOuterAlt(_localctx, 3);
					{
					setState(54); thisType();
					}
					break;
				case 15:
					enterOuterAlt(_localctx, 4);
					{
					setState(56); methodType();
					}
					break;
				case 7:
					enterOuterAlt(_localctx, 5);
					{
					setState(58); multiType();
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
			setState(62); qualifiedName();
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
			setState(64); match(14);
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
			setState(66); match(15);
			setState(68); match(9);
			setState(70); methodParameter();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==6 ) {
				{
				{
				setState(72); match(6);
				setState(74); methodParameter();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); match(4);
			setState(83); match(8);
			setState(85); returnType();
			setState(87); match(18);
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
		public VarOrValOrRefContext varOrValOrRef() {
		    return getRuleContext(VarOrValOrRefContext.class,0);
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
			setState(89); varOrValOrRef();
			setState(91); match(Identifier);
			setState(93); match(8);
			setState(95); typeNode();
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
			setState(97); typeNode();
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

	public static class MultiTypeContext extends ParserRuleContext<Token> {
		public MultiTypeEntryContext multiTypeEntry(int i) {
		    return getRuleContext(MultiTypeEntryContext.class,i);
		}
		public List<? extends MultiTypeEntryContext> multiTypeEntry() {
		    return getRuleContexts(MultiTypeEntryContext.class);
		}
		public MultiTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_multiType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterMultiType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitMultiType(this);
		}
	}

	public final MultiTypeContext multiType() throws RecognitionException {
		MultiTypeContext _localctx = new MultiTypeContext(_ctx, 16);
		enterRule(_localctx, RULE_multiType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(7);
			setState(101); multiTypeEntry();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==6 ) {
				{
				{
				setState(103); match(6);
				setState(105); multiTypeEntry();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(3);
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

	public static class MultiTypeEntryContext extends ParserRuleContext<Token> {
		public TypeNodeContext typeNode() {
		    return getRuleContext(TypeNodeContext.class,0);
		}
		public VarOrValOrRefContext varOrValOrRef() {
		    return getRuleContext(VarOrValOrRefContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(TypeNodeParser.Identifier, 0); }
		public MultiTypeEntryContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_multiTypeEntry; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterMultiTypeEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitMultiTypeEntry(this);
		}
	}

	public final MultiTypeEntryContext multiTypeEntry() throws RecognitionException {
		MultiTypeEntryContext _localctx = new MultiTypeEntryContext(_ctx, 18);
		enterRule(_localctx, RULE_multiTypeEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); varOrValOrRef();
			setState(116); match(Identifier);
			setState(118); match(8);
			setState(120); typeNode();
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
		TypeParameterValueContext _localctx = new TypeParameterValueContext(_ctx, 20);
		enterRule(_localctx, RULE_typeParameterValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(8);
			setState(124); match(Identifier);
			setState(126); match(8);
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

	public static class VarOrValOrRefContext extends ParserRuleContext<Token> {
		public VarOrValOrRefContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_varOrValOrRef; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).enterVarOrValOrRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof TypeNodeListener ) ((TypeNodeListener)listener).exitVarOrValOrRef(this);
		}
	}

	public final VarOrValOrRefContext varOrValOrRef() throws RecognitionException {
		VarOrValOrRefContext _localctx = new VarOrValOrRefContext(_ctx, 22);
		enterRule(_localctx, RULE_varOrValOrRef);
		try {
			setState(134);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 12:
					enterOuterAlt(_localctx, 1);
					{
					setState(128); match(12);
					}
					break;
				case 17:
					enterOuterAlt(_localctx, 2);
					{
					setState(130); match(17);
					}
					break;
				case 10:
					enterOuterAlt(_localctx, 3);
					{
					setState(132); match(10);
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
		NulledContext _localctx = new NulledContext(_ctx, 24);
		enterRule(_localctx, RULE_nulled);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(13);
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
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, 26);
		enterRule(_localctx, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(Identifier);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==5 ) {
				{
				{
				setState(140); match(5);
				setState(142); match(Identifier);
				}
				}
				setState(148);
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
		"\3\26\u0096\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6\2"+
		"\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\1\0\0\1\0\0\3"+
		"\0\b\0\1\0\0\3\0\b\0\1\1\0\1\1\0\1\1\0\1\1\0\3\1\b\1\1\1\1\1\1\2\0\1\2"+
		"\0\1\2\0\1\2\0\1\2\0\3\2\b\2\1\3\1\3\1\4\1\4\1\5\0\1\5\0\1\5\0\1\5\0\1"+
		"\5\0\5\5\b\5\n\5\f\5P\t\5\1\5\0\1\5\0\1\5\0\1\5\1\5\1\6\0\1\6\0\1\6\0"+
		"\1\6\1\6\1\7\1\7\1\b\0\1\b\0\1\b\0\1\b\0\5\b\b\b\n\b\f\bo\t\b\1\b\1\b"+
		"\1\t\0\1\t\0\1\t\0\1\t\1\t\1\n\0\1\n\0\1\n\1\n\1\13\0\1\13\0\1\13\0\3"+
		"\13\b\13\1\f\1\f\1\r\0\1\r\0\1\r\0\5\r\b\r\n\r\f\r\u0094\t\r\1\r\16\0"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\0\0\u0082\0\34\1\0\0\0\1.\1\0\0\0\1"+
		"/\1\0\0\0\1`\1\0\0\0\1b\1\0\0\0\1y\1\0\0\0\2&\1\0\0\0\3!\1\0\0\0\4<\1"+
		"\0\0\0\5 \1\0\0\0\6>\1\0\0\0\7=\1\0\0\0\b@\1\0\0\0\t=\1\0\0\0\nB\1\0\0"+
		"\0\13=\1\0\0\0\fY\1\0\0\0\rN\1\0\0\0\rM\1\0\0\0\16a\1\0\0\0\17W\1\0\0"+
		"\0\20c\1\0\0\0\21=\1\0\0\0\22r\1\0\0\0\23m\1\0\0\0\23l\1\0\0\0\24z\1\0"+
		"\0\0\25=\1\0\0\0\26\u0086\1\0\0\0\27[\1\0\0\0\27t\1\0\0\0\30\u0088\1\0"+
		"\0\0\31%\1\0\0\0\32\u008a\1\0\0\0\33?\1\0\0\0\34 \3\4\2\0\36!\3\2\1\0"+
		" \36\1\0\0\0 !\1\0\0\0!$\1\0\0\0\"%\3\30\f\0$\"\1\0\0\0$%\1\0\0\0%\1\1"+
		"\0\0\0&(\5\13\0\0(.\3\0\0\0*,\5\6\0\0,/\3\0\0\0.*\1\0\0\0./\1\0\0\0/\60"+
		"\1\0\0\0\60\61\5\20\0\0\61\3\1\0\0\0\62=\3\6\3\0\64=\3\24\n\0\66=\3\b"+
		"\4\08=\3\n\5\0:=\3\20\b\0<\62\1\0\0\0<\64\1\0\0\0<\66\1\0\0\0<8\1\0\0"+
		"\0<:\1\0\0\0=\5\1\0\0\0>?\3\32\r\0?\7\1\0\0\0@A\5\16\0\0A\t\1\0\0\0BD"+
		"\5\17\0\0DF\5\t\0\0FN\3\f\6\0HJ\5\6\0\0JM\3\f\6\0LH\1\0\0\0MP\1\0\0\0"+
		"NL\1\0\0\0NO\1\0\0\0OQ\1\0\0\0PN\1\0\0\0QS\5\4\0\0SU\5\b\0\0UW\3\16\7"+
		"\0WX\5\22\0\0X\13\1\0\0\0Y[\3\26\13\0[]\5\23\0\0]_\5\b\0\0_`\3\0\0\0`"+
		"\r\1\0\0\0ab\3\0\0\0b\17\1\0\0\0ce\5\7\0\0em\3\22\t\0gi\5\6\0\0il\3\22"+
		"\t\0kg\1\0\0\0lo\1\0\0\0mk\1\0\0\0mn\1\0\0\0np\1\0\0\0om\1\0\0\0pq\5\3"+
		"\0\0q\21\1\0\0\0rt\3\26\13\0tv\5\23\0\0vx\5\b\0\0xy\3\0\0\0y\23\1\0\0"+
		"\0z|\5\b\0\0|~\5\23\0\0~\177\5\b\0\0\177\25\1\0\0\0\u0080\u0087\5\f\0"+
		"\0\u0082\u0087\5\21\0\0\u0084\u0087\5\n\0\0\u0086\u0080\1\0\0\0\u0086"+
		"\u0082\1\0\0\0\u0086\u0084\1\0\0\0\u0087\27\1\0\0\0\u0088\u0089\5\r\0"+
		"\0\u0089\31\1\0\0\0\u008a\u0092\5\23\0\0\u008c\u008e\5\5\0\0\u008e\u0091"+
		"\5\23\0\0\u0090\u008c\1\0\0\0\u0091\u0094\1\0\0\0\u0092\u0090\1\0\0\0"+
		"\u0092\u0093\1\0\0\0\u0093\33\1\0\0\0\u0094\u0092\1\0\0\0\b \1$\1.\1<"+
		"\1N\1m\1\u0086\1\u0092\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}