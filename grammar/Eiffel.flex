/* JFlex example: partial Java language lexer specification */
//import java_cup.runtime.*;
package ru.spbau.tishchenko.compilers.eiffel.parser;

/**
 * This class is a simple example lexer.
 */
%%

%public
%class EiffelLexer
%unicode
//%cup
%implements Eiffel.Lexer
%line
%column
%integer
%eofval{
  return Eiffel.Lexer.EOF;
%eofval}
%eofclose

%{
  StringBuffer string = new StringBuffer();
  private Object yylval;

  public void yyerror (String s) {
    System.err.println (s);
  }
  
  public Object getLVal() {
    return yylval;
  }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = [ \t\f]

/* comments */
Comment = "--" {InputCharacter}* {LineTerminator}?

Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = 0 | [1-9][0-9]*
RealLiteral = {DecIntegerLiteral}?"."{DecIntegerLiteral} | {DecIntegerLiteral}"." /* no exponent at this stage*/

%state STRING

%%

/* keywords */
/* <YYINITIAL> "abstract"           { return symbol(sym.ABSTRACT); }
<YYINITIAL> "boolean"            { return symbol(sym.BOOLEAN); }
<YYINITIAL> "break"              { return symbol(sym.BREAK); } */

<YYINITIAL> {
  /* literals */
  {DecIntegerLiteral}            { yylval = Integer.parseInt(yytext());
                                   return Eiffel.Lexer.INTEGER_LITERAL; }
  {RealLiteral}                  { yylval = Double.parseDouble(yytext());
                                   return Eiffel.Lexer.REAL_LITERAL; }
  \"                             { string.setLength(0); yybegin(STRING); }
  "True"                         { yylval = Boolean.TRUE;
                                   return Eiffel.Lexer.TRUE; }
  "False"                        { yylval = Boolean.FALSE;
                                   return Eiffel.Lexer.FALSE; }
                                   
  /* control structures */
  "if"                           { return Eiffel.Lexer.IF; }
  "then"                         { return Eiffel.Lexer.THEN; }
  "else"                         { return Eiffel.Lexer.ELSE; }
  "elseif"                       { return Eiffel.Lexer.ELSEIF; }
  "end"                          { return Eiffel.Lexer.END; }
  
  "inspect"                      { return Eiffel.Lexer.INSPECT; }
  "when"                         { return Eiffel.Lexer.WHEN; }
  
  "from"                         { return Eiffel.Lexer.FROM; }
  "until"                        { return Eiffel.Lexer.UNTIL; }
  "loop"                         { return Eiffel.Lexer.LOOP; }
  
  ".."                           { return Eiffel.Lexer.INTERVAL; }
  ","                            { return Eiffel.Lexer.COMMA; }

  /* arithmetic operators */
  ":="                           { return Eiffel.Lexer.ASSIGN; }
  "+"                            { return Eiffel.Lexer.PLUS; }
  "-"                            { return Eiffel.Lexer.MINUS; }
  "*"                            { return Eiffel.Lexer.MULT; }
  "/"                            { return Eiffel.Lexer.RDIV; }
  "//"                           { return Eiffel.Lexer.IDIV; }
  "\\\\"                         { return Eiffel.Lexer.MOD; }
  "^"                            { return Eiffel.Lexer.POW; }
  
  /* relational operators */
  "="                            { return Eiffel.Lexer.EQ; }
  "<="                           { return Eiffel.Lexer.LEQ; }
  ">="                           { return Eiffel.Lexer.GEQ; }
  ">"                            { return Eiffel.Lexer.GT; }
  "<"                            { return Eiffel.Lexer.LT; }
  
  /* binary operators */
  "not"                          { return Eiffel.Lexer.NOT; }
  "and"                          { return Eiffel.Lexer.AND; }
  "or"                           { return Eiffel.Lexer.OR; }
  "xor"                          { return Eiffel.Lexer.XOR; }
/*  "and then"                     { return symbol(sym.ANDTHEN); }
  "or else"                      { return symbol(sym.ORELSE); } */
  "implies"                      { return Eiffel.Lexer.IMPLIES; }
  
  /* identifiers */ 
  {Identifier}                   { yylval = new String(yytext());
                                   return Eiffel.Lexer.IDENTIFIER; }

  /* comments */
  {Comment}                      { /* ignore */ }
 
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
  {LineTerminator}               { /*return Eiffel.Lexer.LINE_TERMINATOR;*/ }
  ";"                            { return Eiffel.Lexer.SEMICOLON; }
  
}

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   yylval = string.toString(); 
                                   return Eiffel.Lexer.STRING_LITERAL; }
  [^\n\r\"%]+                    { string.append( yytext() ); }
  %T                             { string.append('\t'); }
  %N                             { string.append('\n'); }

  %R                             { string.append('\r'); }
  %\"                            { string.append('\"'); }
  %H                             { string.append('\\'); }
  %%                             { string.append('%'); }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }
