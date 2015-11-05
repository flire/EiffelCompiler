/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2013 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package ru.spbau.tishchenko.compilers.eiffel.parser;
/* First part of user declarations.  */

/* "../src/ru/spbau/tishchenko/compilers/eiffel/parser/Eiffel.java":37  */ /* lalr1.java:91  */

/* "../src/ru/spbau/tishchenko/compilers/eiffel/parser/Eiffel.java":39  */ /* lalr1.java:92  */
/* "%code imports" blocks.  */
/* "Eiffel.y":6  */ /* lalr1.java:93  */

    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.*;
    import ru.spbau.tishchenko.compilers.eiffel.language.Operator;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.UnaryStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.BinaryStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

/* "../src/ru/spbau/tishchenko/compilers/eiffel/parser/Eiffel.java":51  */ /* lalr1.java:93  */

/**
 * A Bison parser, automatically generated from <tt>Eiffel.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Eiffel
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Eiffel</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 258;
    /** Token number,to be returned by the scanner.  */
    static final int REAL_LITERAL = 259;
    /** Token number,to be returned by the scanner.  */
    static final int STRING_LITERAL = 260;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 261;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 262;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGN = 263;
    /** Token number,to be returned by the scanner.  */
    static final int MOD = 264;
    /** Token number,to be returned by the scanner.  */
    static final int LINE_TERMINATOR = 265;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 266;
    /** Token number,to be returned by the scanner.  */
    static final int EQ = 267;
    /** Token number,to be returned by the scanner.  */
    static final int LEQ = 268;
    /** Token number,to be returned by the scanner.  */
    static final int GEQ = 269;
    /** Token number,to be returned by the scanner.  */
    static final int GT = 270;
    /** Token number,to be returned by the scanner.  */
    static final int LT = 271;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 272;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 273;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 274;
    /** Token number,to be returned by the scanner.  */
    static final int XOR = 275;
    /** Token number,to be returned by the scanner.  */
    static final int IMPLIES = 276;
    /** Token number,to be returned by the scanner.  */
    static final int MINUS = 277;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 278;
    /** Token number,to be returned by the scanner.  */
    static final int MULT = 279;
    /** Token number,to be returned by the scanner.  */
    static final int RDIV = 280;
    /** Token number,to be returned by the scanner.  */
    static final int IDIV = 281;
    /** Token number,to be returned by the scanner.  */
    static final int POW = 282;
    /** Token number,to be returned by the scanner.  */
    static final int IF = 283;
    /** Token number,to be returned by the scanner.  */
    static final int THEN = 284;
    /** Token number,to be returned by the scanner.  */
    static final int ELSEIF = 285;
    /** Token number,to be returned by the scanner.  */
    static final int ELSE = 286;
    /** Token number,to be returned by the scanner.  */
    static final int END = 287;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Eiffel (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 3:
  if (yyn == 3)
    /* "Eiffel.y":92  */ /* lalr1.java:489  */
    { generator.setCode(((InstructionSequence)(yystack.valueAt (1-(1))))); };
  break;
    

  case 4:
  if (yyn == 4)
    /* "Eiffel.y":96  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (2-(1)))); };
  break;
    

  case 5:
  if (yyn == 5)
    /* "Eiffel.y":97  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (3-(1)))).append(((InstructionSequence)(yystack.valueAt (3-(3))))); };
  break;
    

  case 6:
  if (yyn == 6)
    /* "Eiffel.y":101  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (1-(1)))); };
  break;
    

  case 7:
  if (yyn == 7)
    /* "Eiffel.y":102  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (1-(1)))); };
  break;
    

  case 8:
  if (yyn == 8)
    /* "Eiffel.y":106  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (3-(3)))).setResult(((Variable)(yystack.valueAt (3-(1))))); };
  break;
    

  case 9:
  if (yyn == 9)
    /* "Eiffel.y":110  */ /* lalr1.java:489  */
    { yyval = new Variable(((String)(yystack.valueAt (1-(1))))); };
  break;
    

  case 10:
  if (yyn == 10)
    /* "Eiffel.y":114  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (1-(1)))); };
  break;
    

  case 11:
  if (yyn == 11)
    /* "Eiffel.y":115  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (1-(1)))); };
  break;
    

  case 12:
  if (yyn == 12)
    /* "Eiffel.y":119  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (1-(1)))); };
  break;
    

  case 13:
  if (yyn == 13)
    /* "Eiffel.y":123  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (1-(1)))); };
  break;
    

  case 14:
  if (yyn == 14)
    /* "Eiffel.y":124  */ /* lalr1.java:489  */
    { yyval = ((ExpressionStub)(yystack.valueAt (1-(1)))); };
  break;
    

  case 15:
  if (yyn == 15)
    /* "Eiffel.y":128  */ /* lalr1.java:489  */
    { ExpressionSequence expr = generator.generateExpression(((ExpressionStub)(yystack.valueAt (2-(2)))));
                       Variable arg = expr.result;
                       yyval = ((UnaryStub)((Operator)(yystack.valueAt (2-(1)))).getStub())
                       .setArgument(arg)
                       .insertPreceedingCode(expr); };
  break;
    

  case 16:
  if (yyn == 16)
    /* "Eiffel.y":136  */ /* lalr1.java:489  */
    { ExpressionSequence expr1 = generator.generateExpression(((ExpressionStub)(yystack.valueAt (3-(1)))));
                                   Variable arg1 = expr1.result;
                                   ExpressionSequence expr2 = generator.generateExpression(((ExpressionStub)(yystack.valueAt (3-(3)))));
                                   Variable arg2 = expr2.result;
                                   yyval = ((BinaryStub)((Operator)(yystack.valueAt (3-(2)))).getStub())
                                   .setArguments(arg1, arg2)
                                   .insertPreceedingCode(expr1.append(expr2)); };
  break;
    

  case 17:
  if (yyn == 17)
    /* "Eiffel.y":146  */ /* lalr1.java:489  */
    { yyval = Operator.NOT; };
  break;
    

  case 18:
  if (yyn == 18)
    /* "Eiffel.y":147  */ /* lalr1.java:489  */
    { yyval = Operator.NEG; };
  break;
    

  case 19:
  if (yyn == 19)
    /* "Eiffel.y":148  */ /* lalr1.java:489  */
    { yyval = Operator.UNARY_PLUS; };
  break;
    

  case 20:
  if (yyn == 20)
    /* "Eiffel.y":152  */ /* lalr1.java:489  */
    { yyval = Operator.PLUS; };
  break;
    

  case 21:
  if (yyn == 21)
    /* "Eiffel.y":153  */ /* lalr1.java:489  */
    { yyval = Operator.MINUS; };
  break;
    

  case 22:
  if (yyn == 22)
    /* "Eiffel.y":154  */ /* lalr1.java:489  */
    { yyval = Operator.MULT; };
  break;
    

  case 23:
  if (yyn == 23)
    /* "Eiffel.y":155  */ /* lalr1.java:489  */
    { yyval = Operator.RDIV; };
  break;
    

  case 24:
  if (yyn == 24)
    /* "Eiffel.y":156  */ /* lalr1.java:489  */
    { yyval = Operator.IDIV; };
  break;
    

  case 25:
  if (yyn == 25)
    /* "Eiffel.y":157  */ /* lalr1.java:489  */
    { yyval = Operator.MOD; };
  break;
    

  case 26:
  if (yyn == 26)
    /* "Eiffel.y":159  */ /* lalr1.java:489  */
    { yyval = Operator.EQ; };
  break;
    

  case 27:
  if (yyn == 27)
    /* "Eiffel.y":160  */ /* lalr1.java:489  */
    { yyval = Operator.GT; };
  break;
    

  case 28:
  if (yyn == 28)
    /* "Eiffel.y":161  */ /* lalr1.java:489  */
    { yyval = Operator.LT; };
  break;
    

  case 29:
  if (yyn == 29)
    /* "Eiffel.y":162  */ /* lalr1.java:489  */
    { yyval = Operator.GEQ; };
  break;
    

  case 30:
  if (yyn == 30)
    /* "Eiffel.y":163  */ /* lalr1.java:489  */
    { yyval = Operator.LEQ; };
  break;
    

  case 31:
  if (yyn == 31)
    /* "Eiffel.y":164  */ /* lalr1.java:489  */
    { yyval = Operator.AND; };
  break;
    

  case 32:
  if (yyn == 32)
    /* "Eiffel.y":165  */ /* lalr1.java:489  */
    { yyval = Operator.OR; };
  break;
    

  case 33:
  if (yyn == 33)
    /* "Eiffel.y":166  */ /* lalr1.java:489  */
    { yyval = Operator.XOR; };
  break;
    

  case 34:
  if (yyn == 34)
    /* "Eiffel.y":167  */ /* lalr1.java:489  */
    { yyval = Operator.IMPLIES; };
  break;
    

  case 35:
  if (yyn == 35)
    /* "Eiffel.y":168  */ /* lalr1.java:489  */
    { yyval = Operator.ORELSE; };
  break;
    

  case 36:
  if (yyn == 36)
    /* "Eiffel.y":169  */ /* lalr1.java:489  */
    { yyval = Operator.ANDTHEN; };
  break;
    

  case 37:
  if (yyn == 37)
    /* "Eiffel.y":173  */ /* lalr1.java:489  */
    { yyval = generator.bindConstant(((Object)(yystack.valueAt (1-(1))))); };
  break;
    

  case 38:
  if (yyn == 38)
    /* "Eiffel.y":177  */ /* lalr1.java:489  */
    { yyval = ((Object)(yystack.valueAt (1-(1)))); };
  break;
    

  case 39:
  if (yyn == 39)
    /* "Eiffel.y":181  */ /* lalr1.java:489  */
    { yyval = ((Boolean)(yystack.valueAt (1-(1)))); };
  break;
    

  case 40:
  if (yyn == 40)
    /* "Eiffel.y":182  */ /* lalr1.java:489  */
    { yyval = ((Integer)(yystack.valueAt (1-(1)))); };
  break;
    

  case 41:
  if (yyn == 41)
    /* "Eiffel.y":183  */ /* lalr1.java:489  */
    { yyval = ((Double)(yystack.valueAt (1-(1)))); };
  break;
    

  case 42:
  if (yyn == 42)
    /* "Eiffel.y":184  */ /* lalr1.java:489  */
    { yyval = ((String)(yystack.valueAt (1-(1)))); };
  break;
    

  case 43:
  if (yyn == 43)
    /* "Eiffel.y":188  */ /* lalr1.java:489  */
    { yyval = ((Boolean)(yystack.valueAt (1-(1)))); };
  break;
    

  case 44:
  if (yyn == 44)
    /* "Eiffel.y":189  */ /* lalr1.java:489  */
    { yyval = ((Boolean)(yystack.valueAt (1-(1)))); };
  break;
    

  case 45:
  if (yyn == 45)
    /* "Eiffel.y":193  */ /* lalr1.java:489  */
    { yyval = ((Integer)(yystack.valueAt (1-(1)))); };
  break;
    

  case 46:
  if (yyn == 46)
    /* "Eiffel.y":197  */ /* lalr1.java:489  */
    { yyval = ((Double)(yystack.valueAt (1-(1)))); };
  break;
    

  case 47:
  if (yyn == 47)
    /* "Eiffel.y":201  */ /* lalr1.java:489  */
    { yyval = ((String)(yystack.valueAt (1-(1)))); };
  break;
    

  case 48:
  if (yyn == 48)
    /* "Eiffel.y":205  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (4-(2)))).append(((InstructionSequence)(yystack.valueAt (4-(3))))); };
  break;
    

  case 49:
  if (yyn == 49)
    /* "Eiffel.y":206  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (3-(2)))); };
  break;
    

  case 50:
  if (yyn == 50)
    /* "Eiffel.y":210  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (1-(1)))); };
  break;
    

  case 51:
  if (yyn == 51)
    /* "Eiffel.y":211  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (3-(1)))).append(((InstructionSequence)(yystack.valueAt (3-(3))))); };
  break;
    

  case 52:
  if (yyn == 52)
    /* "Eiffel.y":215  */ /* lalr1.java:489  */
    { ExpressionSequence expr = ((ExpressionSequence)(yystack.valueAt (3-(1))));
                                       yyval = generator.wrapWithIfClause(expr.result, ((InstructionSequence)(yystack.valueAt (3-(3)))))
                                       .insertPreceedingCode(expr); };
  break;
    

  case 53:
  if (yyn == 53)
    /* "Eiffel.y":221  */ /* lalr1.java:489  */
    { yyval = ((InstructionSequence)(yystack.valueAt (2-(2)))); };
  break;
    

  case 54:
  if (yyn == 54)
    /* "Eiffel.y":225  */ /* lalr1.java:489  */
    { yyval = generator.generateExpression(((ExpressionStub)(yystack.valueAt (1-(1))))); };
  break;
    

  case 55:
  if (yyn == 55)
    /* "Eiffel.y":226  */ /* lalr1.java:489  */
    { yyval = generator.generateExpression(generator.bindConstant(((Boolean)(yystack.valueAt (1-(1)))))); };
  break;
    


/* "../src/ru/spbau/tishchenko/compilers/eiffel/parser/Eiffel.java":760  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -33;
  private static final byte yytable_ninf_ = -56;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      -7,   -33,     3,     5,   -33,   -33,     4,   -33,     8,   -33,
     -33,   -33,   -33,   -33,   -33,   -33,   -33,   -33,    20,   -16,
     -33,   -33,   -33,     3,   -33,   -33,   -33,   -12,   -33,   -33,
     -33,   -20,   -11,    -6,   -33,    -7,     3,   -33,   -33,   -33,
     -33,   -33,   -33,     1,   -13,   -33,   -33,   -33,   -33,   -33,
     -33,   -33,     3,    20,   -33,   -33,    -7,   -33,   -10,     3,
      -7,   -33,    20,   -33,   -33,    20,   -33,   -33,   -33,   -33
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,     9,     0,     0,     2,     3,     0,     6,     0,     7,
      45,    46,    47,    43,    44,    17,    18,    19,     0,    10,
      12,    13,    14,     0,    11,    37,    38,    39,    40,    41,
      42,     0,    50,     0,     1,     4,     0,    25,    26,    30,
      29,    27,    28,    31,    32,    33,    34,    21,    20,    22,
      23,    24,     0,    15,    10,    39,     0,    49,     0,     0,
       0,     5,     8,    36,    35,    16,    53,    48,    51,    52
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -33,   -33,   -33,   -32,   -33,   -33,   -33,   -21,    -2,   -33,
     -33,   -33,   -33,   -33,   -33,   -33,   -33,    -1,   -33,   -33,
     -33,   -33,   -22,   -33,   -33,   -33
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     3,     4,     5,     6,     7,     8,    18,    54,    20,
      21,    22,    23,    52,    24,    25,    26,    55,    28,    29,
      30,     9,    31,    32,    58,    33
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte yytable_[] = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      19,    27,    53,    61,     1,    34,    10,    11,    12,    13,
      14,    56,    57,   -54,    35,    62,    36,   -55,    64,    59,
      15,     2,    67,    60,    66,    16,    17,     0,    69,    37,
      63,    65,    38,    39,    40,    41,    42,    68,    43,    44,
      45,    46,    47,    48,    49,    50,    51,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    19,    27
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       2,     2,    23,    35,    11,     0,     3,     4,     5,     6,
       7,    31,    32,    29,    10,    36,     8,    29,    31,    30,
      17,    28,    32,    29,    56,    22,    23,    -1,    60,     9,
      29,    52,    12,    13,    14,    15,    16,    59,    18,    19,
      20,    21,    22,    23,    24,    25,    26,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    59,    59
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,    11,    28,    34,    35,    36,    37,    38,    39,    54,
       3,     4,     5,     6,     7,    17,    22,    23,    40,    41,
      42,    43,    44,    45,    47,    48,    49,    50,    51,    52,
      53,    55,    56,    58,     0,    10,     8,     9,    12,    13,
      14,    15,    16,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    46,    40,    41,    50,    31,    32,    57,    30,
      29,    36,    40,    29,    31,    40,    36,    32,    55,    36
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    33,    34,    35,    36,    36,    37,    37,    38,    39,
      40,    40,    41,    42,    42,    43,    44,    45,    45,    45,
      46,    46,    46,    46,    46,    46,    46,    46,    46,    46,
      46,    46,    46,    46,    46,    46,    46,    47,    48,    49,
      49,    49,    49,    50,    50,    51,    52,    53,    54,    54,
      55,    55,    56,    57,    58,    58
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     1,     2,     3,     1,     1,     3,     1,
       1,     1,     1,     1,     1,     2,     3,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     2,     2,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     4,     3,
       1,     3,     3,     2,     1,     1
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "INTEGER_LITERAL", "REAL_LITERAL",
  "STRING_LITERAL", "TRUE", "FALSE", "ASSIGN", "MOD", "LINE_TERMINATOR",
  "IDENTIFIER", "EQ", "LEQ", "GEQ", "GT", "LT", "NOT", "AND", "OR", "XOR",
  "IMPLIES", "MINUS", "PLUS", "MULT", "RDIV", "IDIV", "POW", "IF", "THEN",
  "ELSEIF", "ELSE", "END", "$accept", "Effective_routine", "Internal",
  "Compound", "Instruction", "Assignment", "Variable", "Expression",
  "Basic_expression", "Operator_expression", "Unary_expression",
  "Binary_expression", "Unary", "Binary", "Special_expression",
  "Manifest_constant", "Manifest_value", "Boolean_constant",
  "Integer_constant", "Real_constant", "Manifest_string", "Conditional",
  "Then_part_list", "Then_part", "Else_part", "Boolean_expression", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    89,    89,    92,    96,    97,   101,   102,   106,   110,
     114,   115,   119,   123,   124,   128,   136,   146,   147,   148,
     152,   153,   154,   155,   156,   157,   159,   160,   161,   162,
     163,   164,   165,   166,   167,   168,   169,   173,   177,   181,
     182,   183,   184,   188,   189,   193,   197,   201,   205,   206,
     210,   211,   215,   221,   225,   226
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 58;
  private static final int yynnts_ = 26;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 34;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 33;

  private static final int yyuser_token_number_max_ = 287;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */
/* Unqualified %code blocks.  */
/* "Eiffel.y":71  */ /* lalr1.java:1066  */

    private int const_counter = 0;
    private int expr_counter = 0;
    
    private IntermediateCodeGenerator generator = IntermediateCodeGenerator.getInstance();
    
    private String getLocalVar() {
        return "e" + Integer.toString(expr_counter++);
    }
    
    private String getStaticVar() {
        return "s" + Integer.toString(const_counter++);
    }

/* "../src/ru/spbau/tishchenko/compilers/eiffel/parser/Eiffel.java":1351  */ /* lalr1.java:1066  */

}

/* "Eiffel.y":228  */ /* lalr1.java:1070  */

