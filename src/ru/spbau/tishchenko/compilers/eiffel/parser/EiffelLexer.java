/* The following code was generated by JFlex 1.4.3 on 11/5/15 5:23 AM */

/* JFlex example: partial Java language lexer specification */
//import java_cup.runtime.*;
package ru.spbau.tishchenko.compilers.eiffel.parser;

/**
 * This class is a simple example lexer.
 */

public class EiffelLexer implements Eiffel.Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\6\1\3\1\2\1\0\1\3\1\1\16\6\4\0\1\3\1\0"+
    "\1\12\1\0\1\5\1\47\4\0\1\34\1\33\1\0\1\4\1\11"+
    "\1\35\1\7\11\10\1\31\1\46\1\40\1\32\1\41\2\0\5\5"+
    "\1\17\1\5\1\52\5\5\1\50\3\5\1\51\1\5\1\13\6\5"+
    "\1\0\1\36\1\0\1\37\1\5\1\0\1\20\2\5\1\30\1\16"+
    "\1\24\1\5\1\26\1\23\2\5\1\21\1\44\1\27\1\42\1\45"+
    "\1\5\1\14\1\22\1\25\1\15\2\5\1\43\2\5\4\0\41\6"+
    "\2\0\4\5\4\0\1\5\2\0\1\6\7\0\1\5\4\0\1\5"+
    "\5\0\27\5\1\0\37\5\1\0\u01ca\5\4\0\14\5\16\0\5\5"+
    "\7\0\1\5\1\0\1\5\21\0\160\6\5\5\1\0\2\5\2\0"+
    "\4\5\10\0\1\5\1\0\3\5\1\0\1\5\1\0\24\5\1\0"+
    "\123\5\1\0\213\5\1\0\5\6\2\0\236\5\11\0\46\5\2\0"+
    "\1\5\7\0\47\5\7\0\1\5\1\0\55\6\1\0\1\6\1\0"+
    "\2\6\1\0\2\6\1\0\1\6\10\0\33\5\5\0\3\5\15\0"+
    "\5\6\6\0\1\5\4\0\13\6\5\0\53\5\37\6\4\0\2\5"+
    "\1\6\143\5\1\0\1\5\10\6\1\0\6\6\2\5\2\6\1\0"+
    "\4\6\2\5\12\6\3\5\2\0\1\5\17\0\1\6\1\5\1\6"+
    "\36\5\33\6\2\0\131\5\13\6\1\5\16\0\12\6\41\5\11\6"+
    "\2\5\4\0\1\5\5\0\26\5\4\6\1\5\11\6\1\5\3\6"+
    "\1\5\5\6\22\0\31\5\3\6\104\0\1\5\1\0\13\5\67\0"+
    "\33\6\1\0\4\6\66\5\3\6\1\5\22\6\1\5\7\6\12\5"+
    "\2\6\2\0\12\6\1\0\7\5\1\0\7\5\1\0\3\6\1\0"+
    "\10\5\2\0\2\5\2\0\26\5\1\0\7\5\1\0\1\5\3\0"+
    "\4\5\2\0\1\6\1\5\7\6\2\0\2\6\2\0\3\6\1\5"+
    "\10\0\1\6\4\0\2\5\1\0\3\5\2\6\2\0\12\6\4\5"+
    "\7\0\1\5\5\0\3\6\1\0\6\5\4\0\2\5\2\0\26\5"+
    "\1\0\7\5\1\0\2\5\1\0\2\5\1\0\2\5\2\0\1\6"+
    "\1\0\5\6\4\0\2\6\2\0\3\6\3\0\1\6\7\0\4\5"+
    "\1\0\1\5\7\0\14\6\3\5\1\6\13\0\3\6\1\0\11\5"+
    "\1\0\3\5\1\0\26\5\1\0\7\5\1\0\2\5\1\0\5\5"+
    "\2\0\1\6\1\5\10\6\1\0\3\6\1\0\3\6\2\0\1\5"+
    "\17\0\2\5\2\6\2\0\12\6\1\0\1\5\17\0\3\6\1\0"+
    "\10\5\2\0\2\5\2\0\26\5\1\0\7\5\1\0\2\5\1\0"+
    "\5\5\2\0\1\6\1\5\7\6\2\0\2\6\2\0\3\6\10\0"+
    "\2\6\4\0\2\5\1\0\3\5\2\6\2\0\12\6\1\0\1\5"+
    "\20\0\1\6\1\5\1\0\6\5\3\0\3\5\1\0\4\5\3\0"+
    "\2\5\1\0\1\5\1\0\2\5\3\0\2\5\3\0\3\5\3\0"+
    "\14\5\4\0\5\6\3\0\3\6\1\0\4\6\2\0\1\5\6\0"+
    "\1\6\16\0\12\6\11\0\1\5\7\0\3\6\1\0\10\5\1\0"+
    "\3\5\1\0\27\5\1\0\12\5\1\0\5\5\3\0\1\5\7\6"+
    "\1\0\3\6\1\0\4\6\7\0\2\6\1\0\2\5\6\0\2\5"+
    "\2\6\2\0\12\6\22\0\2\6\1\0\10\5\1\0\3\5\1\0"+
    "\27\5\1\0\12\5\1\0\5\5\2\0\1\6\1\5\7\6\1\0"+
    "\3\6\1\0\4\6\7\0\2\6\7\0\1\5\1\0\2\5\2\6"+
    "\2\0\12\6\1\0\2\5\17\0\2\6\1\0\10\5\1\0\3\5"+
    "\1\0\51\5\2\0\1\5\7\6\1\0\3\6\1\0\4\6\1\5"+
    "\10\0\1\6\10\0\2\5\2\6\2\0\12\6\12\0\6\5\2\0"+
    "\2\6\1\0\22\5\3\0\30\5\1\0\11\5\1\0\1\5\2\0"+
    "\7\5\3\0\1\6\4\0\6\6\1\0\1\6\1\0\10\6\22\0"+
    "\2\6\15\0\60\5\1\6\2\5\7\6\4\0\10\5\10\6\1\0"+
    "\12\6\47\0\2\5\1\0\1\5\2\0\2\5\1\0\1\5\2\0"+
    "\1\5\6\0\4\5\1\0\7\5\1\0\3\5\1\0\1\5\1\0"+
    "\1\5\2\0\2\5\1\0\4\5\1\6\2\5\6\6\1\0\2\6"+
    "\1\5\2\0\5\5\1\0\1\5\1\0\6\6\2\0\12\6\2\0"+
    "\4\5\40\0\1\5\27\0\2\6\6\0\12\6\13\0\1\6\1\0"+
    "\1\6\1\0\1\6\4\0\2\6\10\5\1\0\44\5\4\0\24\6"+
    "\1\0\2\6\5\5\13\6\1\0\44\6\11\0\1\6\71\0\53\5"+
    "\24\6\1\5\12\6\6\0\6\5\4\6\4\5\3\6\1\5\3\6"+
    "\2\5\7\6\3\5\4\6\15\5\14\6\1\5\17\6\2\0\46\5"+
    "\1\0\1\5\5\0\1\5\2\0\53\5\1\0\u014d\5\1\0\4\5"+
    "\2\0\7\5\1\0\1\5\1\0\4\5\2\0\51\5\1\0\4\5"+
    "\2\0\41\5\1\0\4\5\2\0\7\5\1\0\1\5\1\0\4\5"+
    "\2\0\17\5\1\0\71\5\1\0\4\5\2\0\103\5\2\0\3\6"+
    "\40\0\20\5\20\0\125\5\14\0\u026c\5\2\0\21\5\1\0\32\5"+
    "\5\0\113\5\3\0\3\5\17\0\15\5\1\0\4\5\3\6\13\0"+
    "\22\5\3\6\13\0\22\5\2\6\14\0\15\5\1\0\3\5\1\0"+
    "\2\6\14\0\64\5\40\6\3\0\1\5\3\0\2\5\1\6\2\0"+
    "\12\6\41\0\3\6\2\0\12\6\6\0\130\5\10\0\51\5\1\6"+
    "\1\5\5\0\106\5\12\0\35\5\3\0\14\6\4\0\14\6\12\0"+
    "\12\6\36\5\2\0\5\5\13\0\54\5\4\0\21\6\7\5\2\6"+
    "\6\0\12\6\46\0\27\5\5\6\4\0\65\5\12\6\1\0\35\6"+
    "\2\0\13\6\6\0\12\6\15\0\1\5\130\0\5\6\57\5\21\6"+
    "\7\5\4\0\12\6\21\0\11\6\14\0\3\6\36\5\15\6\2\5"+
    "\12\6\54\5\16\6\14\0\44\5\24\6\10\0\12\6\3\0\3\5"+
    "\12\6\44\5\122\0\3\6\1\0\25\6\4\5\1\6\4\5\3\6"+
    "\2\5\11\0\300\5\47\6\25\0\4\6\u0116\5\2\0\6\5\2\0"+
    "\46\5\2\0\6\5\2\0\10\5\1\0\1\5\1\0\1\5\1\0"+
    "\1\5\1\0\37\5\2\0\65\5\1\0\7\5\1\0\1\5\3\0"+
    "\3\5\1\0\7\5\3\0\4\5\2\0\6\5\4\0\15\5\5\0"+
    "\3\5\1\0\7\5\16\0\5\6\32\0\5\6\20\0\2\5\23\0"+
    "\1\5\13\0\5\6\5\0\6\6\1\0\1\5\15\0\1\5\20\0"+
    "\15\5\3\0\33\5\25\0\15\6\4\0\1\6\3\0\14\6\21\0"+
    "\1\5\4\0\1\5\2\0\12\5\1\0\1\5\3\0\5\5\6\0"+
    "\1\5\1\0\1\5\1\0\1\5\1\0\4\5\1\0\13\5\2\0"+
    "\4\5\5\0\5\5\4\0\1\5\21\0\51\5\u0a77\0\57\5\1\0"+
    "\57\5\1\0\205\5\6\0\4\5\3\6\2\5\14\0\46\5\1\0"+
    "\1\5\5\0\1\5\2\0\70\5\7\0\1\5\17\0\1\6\27\5"+
    "\11\0\7\5\1\0\7\5\1\0\7\5\1\0\7\5\1\0\7\5"+
    "\1\0\7\5\1\0\7\5\1\0\7\5\1\0\40\6\57\0\1\5"+
    "\u01d5\0\3\5\31\0\11\5\6\6\1\0\5\5\2\0\5\5\4\0"+
    "\126\5\2\0\2\6\2\0\3\5\1\0\132\5\1\0\4\5\5\0"+
    "\51\5\3\0\136\5\21\0\33\5\65\0\20\5\u0200\0\u19b6\5\112\0"+
    "\u51cd\5\63\0\u048d\5\103\0\56\5\2\0\u010d\5\3\0\20\5\12\6"+
    "\2\5\24\0\57\5\1\6\4\0\12\6\1\0\31\5\7\0\1\6"+
    "\120\5\2\6\45\0\11\5\2\0\147\5\2\0\4\5\1\0\4\5"+
    "\14\0\13\5\115\0\12\5\1\6\3\5\1\6\4\5\1\6\27\5"+
    "\5\6\20\0\1\5\7\0\64\5\14\0\2\6\62\5\21\6\13\0"+
    "\12\6\6\0\22\6\6\5\3\0\1\5\4\0\12\6\34\5\10\6"+
    "\2\0\27\5\15\6\14\0\35\5\3\0\4\6\57\5\16\6\16\0"+
    "\1\5\12\6\46\0\51\5\16\6\11\0\3\5\1\6\10\5\2\6"+
    "\2\0\12\6\6\0\27\5\3\0\1\5\1\6\4\0\60\5\1\6"+
    "\1\5\3\6\2\5\2\6\5\5\2\6\1\5\1\6\1\5\30\0"+
    "\3\5\2\0\13\5\5\6\2\0\3\5\2\6\12\0\6\5\2\0"+
    "\6\5\2\0\6\5\11\0\7\5\1\0\7\5\221\0\43\5\10\6"+
    "\1\0\2\6\2\0\12\6\6\0\u2ba4\5\14\0\27\5\4\0\61\5"+
    "\u2104\0\u016e\5\2\0\152\5\46\0\7\5\14\0\5\5\5\0\1\5"+
    "\1\6\12\5\1\0\15\5\1\0\5\5\1\0\1\5\1\0\2\5"+
    "\1\0\2\5\1\0\154\5\41\0\u016b\5\22\0\100\5\2\0\66\5"+
    "\50\0\15\5\3\0\20\6\20\0\7\6\14\0\2\5\30\0\3\5"+
    "\31\0\1\5\6\0\5\5\1\0\207\5\2\0\1\6\4\0\1\5"+
    "\13\0\12\6\7\0\32\5\4\0\1\5\1\0\32\5\13\0\131\5"+
    "\3\0\6\5\2\0\6\5\2\0\6\5\2\0\3\5\3\0\2\5"+
    "\3\0\2\5\22\0\3\6\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\1\5\2\6\1\1"+
    "\1\7\7\5\1\1\1\10\1\11\1\12\1\13\1\1"+
    "\1\14\1\15\1\16\2\5\1\17\1\20\1\21\1\1"+
    "\1\3\3\22\5\5\1\23\3\5\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\5\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\3\2\5\1\40\1\5\1\41\2\5"+
    "\1\42\1\43\1\44\1\45\2\5\1\46\1\5\1\47"+
    "\1\5\1\50\1\5\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\126\0\126\0\254\0\327"+
    "\0\u0102\0\u012d\0\u0158\0\126\0\u0183\0\u01ae\0\u01d9\0\u0204"+
    "\0\u022f\0\u025a\0\u0285\0\u02b0\0\126\0\126\0\126\0\u02db"+
    "\0\u0306\0\126\0\u0331\0\u035c\0\u0387\0\u03b2\0\126\0\u03dd"+
    "\0\126\0\u0408\0\u0433\0\u0158\0\126\0\u045e\0\u0489\0\u04b4"+
    "\0\u04df\0\u050a\0\u0535\0\327\0\u0560\0\u058b\0\u05b6\0\126"+
    "\0\126\0\126\0\126\0\126\0\327\0\u05e1\0\126\0\126"+
    "\0\126\0\126\0\126\0\126\0\u060c\0\u0637\0\u0662\0\327"+
    "\0\u068d\0\327\0\u06b8\0\u06e3\0\327\0\327\0\327\0\u070e"+
    "\0\u0739\0\u0764\0\327\0\u078f\0\327\0\u07ba\0\327\0\u07e5"+
    "\0\327";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\3\1\11"+
    "\1\12\1\13\1\14\1\15\2\10\1\16\1\17\1\20"+
    "\2\10\1\21\1\10\1\22\1\10\1\23\1\10\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\2\10\1\37\1\3\3\10\1\40\2\3"+
    "\7\40\1\41\34\40\1\42\3\40\55\0\1\5\54\0"+
    "\1\43\53\0\4\10\2\0\16\10\11\0\4\10\2\0"+
    "\3\10\11\0\1\44\50\0\2\12\1\44\50\0\1\45"+
    "\1\46\47\0\4\10\2\0\1\10\1\47\14\10\11\0"+
    "\4\10\2\0\3\10\5\0\4\10\2\0\6\10\1\50"+
    "\5\10\1\51\1\10\11\0\4\10\2\0\3\10\5\0"+
    "\4\10\2\0\5\10\1\52\10\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\14\10\1\53\1\10\11\0"+
    "\4\10\2\0\3\10\5\0\4\10\2\0\11\10\1\54"+
    "\4\10\11\0\2\10\1\55\1\10\2\0\3\10\5\0"+
    "\4\10\2\0\13\10\1\56\2\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\16\10\11\0\1\57\3\10"+
    "\2\0\3\10\32\0\1\60\55\0\1\61\53\0\1\62"+
    "\46\0\1\63\52\0\1\64\25\0\4\10\2\0\1\10"+
    "\1\65\14\10\11\0\4\10\2\0\3\10\5\0\4\10"+
    "\2\0\16\10\11\0\1\66\3\10\2\0\3\10\1\40"+
    "\2\0\7\40\1\0\34\40\1\0\3\40\12\0\1\67"+
    "\1\70\33\0\1\71\1\72\1\73\1\74\1\43\1\75"+
    "\1\6\50\43\7\0\2\46\47\0\4\10\2\0\2\10"+
    "\1\76\13\10\11\0\4\10\2\0\3\10\5\0\4\10"+
    "\2\0\7\10\1\77\6\10\11\0\4\10\2\0\3\10"+
    "\5\0\4\10\2\0\15\10\1\100\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\6\10\1\101\7\10\11\0"+
    "\4\10\2\0\3\10\5\0\4\10\2\0\15\10\1\102"+
    "\11\0\4\10\2\0\3\10\5\0\4\10\2\0\16\10"+
    "\11\0\3\10\1\103\2\0\3\10\5\0\4\10\2\0"+
    "\3\10\1\104\12\10\11\0\4\10\2\0\3\10\5\0"+
    "\4\10\2\0\12\10\1\105\3\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\1\10\1\106\14\10\11\0"+
    "\4\10\2\0\3\10\2\0\1\6\55\0\4\10\2\0"+
    "\3\10\1\107\12\10\11\0\4\10\2\0\3\10\5\0"+
    "\4\10\2\0\3\10\1\110\12\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\7\10\1\111\6\10\11\0"+
    "\4\10\2\0\3\10\5\0\4\10\2\0\6\10\1\112"+
    "\7\10\11\0\4\10\2\0\3\10\5\0\4\10\2\0"+
    "\14\10\1\113\1\10\11\0\4\10\2\0\3\10\5\0"+
    "\4\10\2\0\10\10\1\114\5\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\3\10\1\115\12\10\11\0"+
    "\4\10\2\0\3\10\5\0\4\10\2\0\10\10\1\116"+
    "\5\10\11\0\4\10\2\0\3\10\5\0\4\10\2\0"+
    "\11\10\1\117\4\10\11\0\4\10\2\0\3\10\5\0"+
    "\4\10\2\0\3\10\1\120\12\10\11\0\4\10\2\0"+
    "\3\10\5\0\4\10\2\0\7\10\1\121\6\10\11\0"+
    "\4\10\2\0\3\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2064];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\2\11\5\1\1\11\10\1\3\11"+
    "\2\1\1\11\4\1\1\11\1\1\1\11\3\1\1\11"+
    "\12\1\5\11\2\1\6\11\25\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  StringBuffer string = new StringBuffer();
  private Object yylval;

  public void yyerror (String s) {
    System.err.println (s);
  }
  
  public Object getLVal() {
    return yylval;
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public EiffelLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public EiffelLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2250) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 3: 
          { /* ignore */
          }
        case 42: break;
        case 11: 
          { return Eiffel.Lexer.RDIV;
          }
        case 43: break;
        case 4: 
          { return Eiffel.Lexer.MINUS;
          }
        case 44: break;
        case 14: 
          { return Eiffel.Lexer.GT;
          }
        case 45: break;
        case 27: 
          { string.append('\t');
          }
        case 46: break;
        case 7: 
          { string.setLength(0); yybegin(STRING);
          }
        case 47: break;
        case 5: 
          { yylval = new String(yytext());
                                   return Eiffel.Lexer.IDENTIFIER;
          }
        case 48: break;
        case 38: 
          { return Eiffel.Lexer.THEN;
          }
        case 49: break;
        case 37: 
          { return Eiffel.Lexer.ELSE;
          }
        case 50: break;
        case 31: 
          { string.append('\\');
          }
        case 51: break;
        case 20: 
          { return Eiffel.Lexer.ASSIGN;
          }
        case 52: break;
        case 32: 
          { return Eiffel.Lexer.END;
          }
        case 53: break;
        case 30: 
          { string.append('\r');
          }
        case 54: break;
        case 8: 
          { return Eiffel.Lexer.EQ;
          }
        case 55: break;
        case 1: 
          { throw new Error("Illegal character <"+
                                                    yytext()+">");
          }
        case 56: break;
        case 6: 
          { yylval = Integer.parseInt(yytext());
                                   return Eiffel.Lexer.INTEGER_LITERAL;
          }
        case 57: break;
        case 40: 
          { return Eiffel.Lexer.ELSEIF;
          }
        case 58: break;
        case 15: 
          { return Eiffel.Lexer.LINE_TERMINATOR;
          }
        case 59: break;
        case 35: 
          { return Eiffel.Lexer.XOR;
          }
        case 60: break;
        case 41: 
          { return Eiffel.Lexer.IMPLIES;
          }
        case 61: break;
        case 9: 
          { return Eiffel.Lexer.PLUS;
          }
        case 62: break;
        case 19: 
          { return Eiffel.Lexer.IF;
          }
        case 63: break;
        case 18: 
          { yylval = Double.parseDouble(yytext());
                                   return Eiffel.Lexer.REAL_LITERAL;
          }
        case 64: break;
        case 22: 
          { return Eiffel.Lexer.MOD;
          }
        case 65: break;
        case 26: 
          { string.append('\"');
          }
        case 66: break;
        case 21: 
          { return Eiffel.Lexer.IDIV;
          }
        case 67: break;
        case 12: 
          { return Eiffel.Lexer.POW;
          }
        case 68: break;
        case 28: 
          { string.append('%');
          }
        case 69: break;
        case 13: 
          { return Eiffel.Lexer.LT;
          }
        case 70: break;
        case 2: 
          { /*return Eiffel.Lexer.LINE_TERMINATOR;*/
          }
        case 71: break;
        case 33: 
          { return Eiffel.Lexer.AND;
          }
        case 72: break;
        case 34: 
          { return Eiffel.Lexer.NOT;
          }
        case 73: break;
        case 36: 
          { yylval = Boolean.TRUE;
                                   return Eiffel.Lexer.TRUE;
          }
        case 74: break;
        case 10: 
          { return Eiffel.Lexer.MULT;
          }
        case 75: break;
        case 29: 
          { string.append('\n');
          }
        case 76: break;
        case 39: 
          { yylval = Boolean.FALSE;
                                   return Eiffel.Lexer.FALSE;
          }
        case 77: break;
        case 25: 
          { return Eiffel.Lexer.OR;
          }
        case 78: break;
        case 24: 
          { return Eiffel.Lexer.GEQ;
          }
        case 79: break;
        case 17: 
          { yybegin(YYINITIAL);
                                   yylval = string.toString(); 
                                   return Eiffel.Lexer.STRING_LITERAL;
          }
        case 80: break;
        case 16: 
          { string.append( yytext() );
          }
        case 81: break;
        case 23: 
          { return Eiffel.Lexer.LEQ;
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {   return Eiffel.Lexer.EOF;
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
