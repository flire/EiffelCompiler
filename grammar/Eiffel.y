%language "Java"
%name-prefix "Eiffel"
%define parser_class_name {Eiffel}
%define public
%define package ru.spbau.tishchenko.compilers.eiffel.parser
%code imports {
    import java.util.ArrayList;
    import java.util.Arrays;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.*;
    import ru.spbau.tishchenko.compilers.eiffel.language.Operator;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.*;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.StringConstant;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.BoolConstant;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntegerConstant;
    import ru.spbau.tishchenko.compilers.eiffel.codegeneration.RealConstant;
}

/* Bison Declarations */
%token <Integer> INTEGER_LITERAL
%token <Double> REAL_LITERAL
%token <String> STRING_LITERAL

%token <Boolean> TRUE
%token <Boolean> FALSE

%token ASSIGN

%token <String> IDENTIFIER

%type <IntegerConstant> Integer_constant
%type <RealConstant> Real_constant
%type <StringConstant> Manifest_string
%type <BoolConstant> Boolean_constant

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
%type <ExpressionStub> Local
%type <Symbol> Constant
%type <Symbol> Manifest_constant
%type <Symbol> Manifest_value

%type <WhenInterval> Constant_interval
%type <WhenCondition> Choice 
%type <InstructionSequence> Multibranch
%type <SingleVariableStub> When_part_list
%type <SingleVariableStub> When_part
%type <ArrayList<WhenCondition>> Choices

%nonassoc EQ LEQ GEQ GT LT /* comparison            */
%left OR OR_ELSE XOR IMPLIES
%left AND AND_THEN
%left NOT
%left MINUS PLUS /* 1- 2 -3 */
%left MULT RDIV IDIV MOD
%left UMINUS UPLUS
%left POW    /* exponentiation        */

%token IF
%token THEN
%token ELSEIF
%token ELSE
%token END

%token INSPECT
%token WHEN

%token INTERVAL
%token COMMA

%token SEMICOLON

%code {
    private IntermediateCodeGenerator generator = IntermediateCodeGenerator.getInstance();
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
    Instruction OPTIONAL_SEMICOLON { $$ = $1; }
    | Compound OPTIONAL_SEMICOLON Instruction { $$ = $1.append($3); }
;

OPTIONAL_SEMICOLON:
    /*empty*/
    | SEMICOLON
;
    
Instruction:
    Assignment { $$ = $1; }
    | Conditional { $$ = $1; }
    | Multibranch
;
    
Assignment:
    Variable ASSIGN Expression { $$ = $3.assignTo($1); }
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
    | Local { $$ = $1; }
;
    
Operator_expression :
    NOT Expression { $$ = Operator.NOT.getStub($2);}
    | MINUS Expression %prec UMINUS { $$ = Operator.NEG.getStub($2);}
    | PLUS Expression %prec UPLUS { $$ = $2; }
    | Expression PLUS Expression { $$ = Operator.PLUS.getStub($1, $3); }
    | Expression MINUS Expression { $$ = Operator.MINUS.getStub($1, $3); }
    | Expression MULT Expression { $$ = Operator.MULT.getStub($1, $3); }
    | Expression RDIV Expression { $$ = Operator.RDIV.getStub($1, $3); }
    | Expression IDIV Expression { $$ = Operator.IDIV.getStub($1, $3); }
    | Expression MOD Expression { $$ = Operator.MOD.getStub($1, $3); }
    | Expression EQ Expression { $$ = Operator.EQ.getStub($1, $3); }
    | Expression LT Expression { $$ = Operator.LT.getStub($1, $3); }
    | Expression GT Expression { $$ = Operator.GT.getStub($1, $3); }
    | Expression GEQ Expression { $$ = Operator.GEQ.getStub($1, $3); }
    | Expression LEQ Expression { $$ = Operator.LEQ.getStub($1, $3); }
    | Expression AND Expression { $$ = Operator.AND.getStub($1, $3); }
    | Expression OR Expression { $$ = Operator.OR.getStub($1, $3); }
    | Expression XOR Expression { $$ = Operator.XOR.getStub($1, $3); }
    | Expression IMPLIES Expression { $$ = Operator.IMPLIES.getStub($1, $3); }
    | Expression OR ELSE Expression { $$ = Operator.ORELSE.getStub($1, $4); }
    | Expression AND THEN Expression { $$ = Operator.ANDTHEN.getStub($1, $4); }
;

Local:
    Variable { $$ = generator.createConstantExpression($1); }
    
Special_expression:
    Manifest_constant { $$ = generator.createConstantExpression($1); }
;

Constant:
    Manifest_constant { $$ = $1; }
    
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
    TRUE { $$ = new BoolConstant($1); }
    | FALSE { $$ = new BoolConstant($1); }
;
    
Integer_constant:
    INTEGER_LITERAL { $$ = new IntegerConstant($1); }
;
    
Real_constant:
    REAL_LITERAL { $$ = new RealConstant($1); }
;
    
Manifest_string:
    STRING_LITERAL { $$ = generator.createStringConstant($1); }
;

Conditional :
    IF Then_part_list Else_part END { $2.moveLongJumps(); $$ = $2.append($3); }
    | IF Then_part_list END { $2.moveLongJumps(); $$ = $2; }
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
    | Boolean_constant { $$ = generator.createConstantExpression($1).getExpression(); }
;

Multibranch :
    INSPECT Expression When_part_list Else_part END { $$ = generator.createInspect($2, $3, $4); }
    | INSPECT Expression When_part_list END { $$ = generator.createInspect($2, $3, null); }
;

When_part_list :
    When_part_list When_part { $1.append($2); $$ = $1; }
    | When_part { $$ = $1; }
;

When_part :
    WHEN Choices THEN Compound { $$ = generator.wrapWithWhenClause($2, $4); }
;

Choices :
    Choices COMMA Choice { $1.add($3); $$ = $1; }
    | Choice { $$ = new ArrayList<WhenCondition>(Arrays.asList($1)); }
;

Choice :
    Constant { $$ = new WhenConstant($1); }
    | Constant_interval { $$ = $1; }
;

Constant_interval :
    Constant INTERVAL Constant { $$ = new WhenInterval($1, $3);}
;
%%
