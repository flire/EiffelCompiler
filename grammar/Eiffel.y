%language "Java"
%name-prefix "Eiffel"
%define parser_class_name {Eiffel}
%define public
%define package ru.spbau.tishchenko.compilers.eiffel.parser

/* Bison Declarations */
/*%token <Integer> NUM "number"*/
%token <Integer> INTEGER_LITERAL
%token <Double> REAL_LITERAL
%token <String> STRING_LITERAL

%token <Boolean> TRUE
%token <Boolean> FALSE

%token ASSIGN

%token MOD

%token LINE_TERMINATOR

%token <String> IDENTIFIER

%type <Integer> Integer_constant
%type <Double> Real_constant
%type <String> Manifest_string
%type <Boolean> Boolean_constant

%type <String> Variable /* targets id */
%type <String> Expression /* targets memory area */
%type <String> Basic_expression
%type <String> Special_expression
%type <String> Operator_expression
%type <String> Unary_expression
%type <String> Binary_expression
%type <String> Manifest_constant
%type <String> Manifest_value
%type <String> Binary
%type <String> Unary

%nonassoc EQ LEQ GEQ GT LT /* comparison            */
%left NOT AND OR XOR IMPLIES
%left MINUS PLUS
%left MULT RDIV IDIV
%left POW    /* exponentiation        */

%code {
    private int const_counter = 0;
    private int expr_counter = 0;
    
    private String getLocalVar() {
        return "e" + Integer.toString(expr_counter++);
    }
    
    private String getStaticVar() {
        return "s" + Integer.toString(const_counter++);
    }
}

/* Grammar follows */
%%
Compound:
    Instruction LINE_TERMINATOR
    | Compound Instruction LINE_TERMINATOR
;
    
Instruction:
    Assignment
;
    
Assignment:
    Variable ASSIGN Expression { System.out.println($1 + " := " + $3); }
;
    
Variable:
    IDENTIFIER { $$ = $1; }
;

Expression:
    Basic_expression { $$ = $1; }
    | Special_expression { $$ = $1; }
;
    
Basic_expression:
    Operator_expression { $$ = $1; }
;
    
Operator_expression :
    Unary_expression { $$ = $1; }
    | Binary_expression { $$ = $1; }
;
    
Unary_expression:
    Unary Expression { $$ = getLocalVar();
                       System.out.println($$ + " := " + $1 + " " + $2); }
;

Binary_expression:
    Expression Binary Expression { $$ = getLocalVar();
                                   System.out.println($$ + " := " + $1 + " " + $2 + " " + $3); }
;
    
Unary:
    NOT { $$ = "not"; }
;
    
Binary:
    PLUS { $$ = "+"; }
    | MINUS { $$ = "-"; }
    | MULT { $$ = "*"; }
    | RDIV { $$ = "/"; }
    | IDIV { $$ = "//"; }
    | MOD { $$ = "\\\\"; }
    | POW { $$ = "^"; }
    | EQ { $$ = "="; }
    | GT { $$ = ">"; }
    | LT { $$ = "<"; }
    | GEQ { $$ = ">="; }
    | LEQ { $$ = "<="; }
    | AND { $$ = "and"; }
    | OR { $$ = "or"; }
    | XOR { $$ = "xor"; }
    | IMPLIES { $$ = "implies"; }
;
    
Special_expression:
    Manifest_constant {$$ = $1; }
;
    
Manifest_constant:
    Manifest_value { $$ = $1; }
;
    
Manifest_value:
    Boolean_constant { $$ = getStaticVar();
                       System.out.println($$ + " := " + $1.toString()); } 
    | Integer_constant { $$ = getStaticVar();
                         System.out.println($$ + " := " + $1.toString()); } 
    | Real_constant { $$ = getStaticVar();
                      System.out.println($$ + " := " + $1.toString()); } 
    | Manifest_string { $$ = getStaticVar();
                        System.out.println($$ + " := " + $1.toString()); }
;
    
Boolean_constant:
    TRUE { $$ = $1; }
    | FALSE { $$ = $1; }
;
    
Integer_constant:
    INTEGER_LITERAL { $$ = $1; }
;
    
Real_constant:
    REAL_LITERAL { $$ = $1; }
;
    
Manifest_string:
    STRING_LITERAL { $$ = $1; }
;

/*input:
  line 
  | input line
;

line:
  '\n'
| exp '\n' { System.out.println($1.intValue()); }
| error '\n'
;

exp:
  NUM                { $$ = $1;                                             }
| exp '=' exp
  {
    if ($1.intValue () != $3.intValue ())
      yyerror ( "calc: error: " + $1 + " != " + $3);
  }
| exp '+' exp        { $$ = new Integer ($1.intValue () + $3.intValue ());  }
| exp '-' exp        { $$ = new Integer ($1.intValue () - $3.intValue ());  }
| exp '*' exp        { $$ = new Integer ($1.intValue () * $3.intValue ());  }
| exp '/' exp        { $$ = new Integer ($1.intValue () / $3.intValue ());  }
| '-' exp  %prec NEG { $$ = new Integer (-$2.intValue ());                  }
| exp '^' exp        { $$ = new Integer ((int)
                                         Math.pow ($1.intValue (),
                                                   $3.intValue ()));        }
| '(' exp ')'        { $$ = $2;                                             }
| '(' error ')'      { $$ = new Integer (1111);                             }
| '!'                { $$ = new Integer (0); return YYERROR;                }
| '-' error          { $$ = new Integer (0); return YYERROR;                }
; */

%%
