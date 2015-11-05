%language "Java"
%name-prefix "Eiffel"
%define parser_class_name {Eiffel}
%define public
%define package ru.spbau.tishchenko.compilers.eiffel.parser
%code imports {
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.*;
    import ru.spbau.tishchenko.compilers.eiffel.language.Operator;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.UnaryStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.BinaryStub;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
}

/* Bison Declarations */
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

%type <InstructionSequence> Assignment
%type <InstructionSequence> Instruction
%type <InstructionSequence> Compound
%type <InstructionSequence> Conditional
%type <InstructionSequence> Then_part_list
%type <InstructionSequence> Then_part
%type <InstructionSequence> Else_part

%type <ExpressionSequence> Boolean_expression

%type <Variable> Variable /* targets id */
%type <ExpressionStub> Expression /* targets memory area */
%type <ExpressionStub> Basic_expression
%type <ExpressionStub> Special_expression
%type <ExpressionStub> Operator_expression
%type <ExpressionStub> Unary_expression
%type <ExpressionStub> Binary_expression
%type <Object> Manifest_constant
%type <Object> Manifest_value
%type <Operator> Binary
%type <Operator> Unary

%nonassoc EQ LEQ GEQ GT LT /* comparison            */
%left NOT AND OR XOR IMPLIES
%left MINUS PLUS
%left MULT RDIV IDIV
%left POW    /* exponentiation        */

%token IF
%token THEN
%token ELSEIF
%token ELSE
%token END

%code {
    private int const_counter = 0;
    private int expr_counter = 0;
    
    private IntermediateCodeGenerator generator = IntermediateCodeGenerator.getInstance();
    
    private String getLocalVar() {
        return "e" + Integer.toString(expr_counter++);
    }
    
    private String getStaticVar() {
        return "s" + Integer.toString(const_counter++);
    }
}

/* Grammar follows */
%%
Effective_routine :
    Internal
;
Internal :
    Compound { generator.setCode($1); }
;

Compound:
    Instruction LINE_TERMINATOR { $$ = $1; }
    | Instruction LINE_TERMINATOR Compound { $$ = $1.append($3); }
;
    
Instruction:
    Assignment { $$ = $1; }
    | Conditional { $$ = $1; }
;
    
Assignment:
    Variable ASSIGN Expression { $$ = $3.setResult($1); }
;
    
Variable:
    IDENTIFIER { $$ = new Variable($1); }
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
    Unary Expression { ExpressionSequence expr = generator.generateExpression($2);
                       Variable arg = expr.result;
                       $$ = ((UnaryStub)$1.getStub())
                       .setArgument(arg)
                       .insertPreceedingCode(expr); }
;

Binary_expression:
    Expression Binary Expression { ExpressionSequence expr1 = generator.generateExpression($1);
                                   Variable arg1 = expr1.result;
                                   ExpressionSequence expr2 = generator.generateExpression($3);
                                   Variable arg2 = expr2.result;
                                   $$ = ((BinaryStub)$2.getStub())
                                   .setArguments(arg1, arg2)
                                   .insertPreceedingCode(expr1.append(expr2)); }
;
    
Unary:
    NOT { $$ = Operator.NOT; }
    | MINUS { $$ = Operator.NEG; }
    | PLUS { $$ = Operator.UNARY_PLUS; }
;
    
Binary:
    PLUS { $$ = Operator.PLUS; }
    | MINUS { $$ = Operator.MINUS; }
    | MULT { $$ = Operator.MULT; }
    | RDIV { $$ = Operator.RDIV; }
    | IDIV { $$ = Operator.IDIV; }
    | MOD { $$ = Operator.MOD; }
    /*| POW { $$ = Operator.ADD; }*/
    | EQ { $$ = Operator.EQ; }
    | GT { $$ = Operator.GT; }
    | LT { $$ = Operator.LT; }
    | GEQ { $$ = Operator.GEQ; }
    | LEQ { $$ = Operator.LEQ; }
    | AND { $$ = Operator.AND; }
    | OR { $$ = Operator.OR; }
    | XOR { $$ = Operator.XOR; }
    | IMPLIES { $$ = Operator.IMPLIES; }
    | OR ELSE { $$ = Operator.ORELSE; }
    | AND THEN { $$ = Operator.ANDTHEN; }
;
    
Special_expression:
    Manifest_constant { $$ = generator.bindConstant($1); }
;
    
Manifest_constant:
    Manifest_value { $$ = $1; }
;
    
Manifest_value:
    Boolean_constant { $$ = $1; } 
    | Integer_constant { $$ = $1; } 
    | Real_constant { $$ = $1; } 
    | Manifest_string { $$ = $1; }
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

Conditional :
    IF Then_part_list Else_part END { $$ = $2.append($3); }
    | IF Then_part_list END { $$ = $2; }
;

Then_part_list :
    Then_part { $$ = $1; }
    | Then_part ELSEIF Then_part_list { $$ = $1.append($3); }
;

Then_part :
    Boolean_expression THEN Compound { ExpressionSequence expr = $1;
                                       $$ = generator.wrapWithIfClause(expr.result, $3)
                                       .insertPreceedingCode(expr); }
;

Else_part :
    ELSE Compound { $$ = $2; }
;

Boolean_expression :
    Basic_expression { $$ = generator.generateExpression($1); }
    | Boolean_constant { $$ = generator.generateExpression(generator.bindConstant($1)); }
;
%%
