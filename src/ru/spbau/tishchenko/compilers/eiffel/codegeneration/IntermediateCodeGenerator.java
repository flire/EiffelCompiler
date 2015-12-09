package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;
import java.util.List;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Conditional;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ConstantStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.SingleVariableStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.WhenCondition;

public class IntermediateCodeGenerator {

	public static IntermediateCodeGenerator getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void setCode(InstructionSequence code) {
		instructions = code.instructions;
	}

	public ExpressionSequence generateExpression(ExpressionStub expression) {
		if (expression.isVariableNeeded()) {
			Variable expressionResult = variablePool.getLocalVariable();
			expression.setResult(expressionResult);
		}
		return expression.getExpression();
	}
	
	public StringConstant createStringConstant(String str) {
		Variable constantVar = variablePool.getStaticVariable();
		constants.addConstant(constantVar, str);
		return new StringConstant(constantVar.toString());
	}

	public ExpressionStub bindConstant(Object constant) {
		Variable constantVar = variablePool.getStaticVariable();
		constants.addConstant(constantVar, constant);
		return ExpressionStub.StubWithVariable(constantVar);
	}
	
	public ExpressionStub createConstantExpression(Symbol constant) {
		return new ConstantStub(constant);
	}
	
	public Jump jumpWithSymbol(Operation operation, Symbol symbol) throws IllegalArgumentException {
		if (symbol instanceof BoolConstant) {
			if (((BoolConstant) symbol).value == (operation == Operation.IF)) {
				return new Jump(Operation.GOTO);
			}
			return null;
		}
		if (symbol instanceof Variable) {
			return new Conditional(operation, (Variable) symbol);
		}
		throw new IllegalArgumentException("Expected boolean expression");
	}
	
	public InstructionSequence wrapWithIfClause(Symbol conditionVar, InstructionSequence code) throws IllegalArgumentException {
		if (conditionVar instanceof BoolConstant) {
			return wrapWithJump(((BoolConstant) conditionVar).value, code);
		}
		if (conditionVar instanceof Variable) {
			return wrapWithIfClause((Variable)conditionVar, code);
		}
		throw new IllegalArgumentException("Expected boolean expression in if clause");
	}

	private InstructionSequence wrapWithJump(boolean value, InstructionSequence code) {
		if (!value) {
			Jump jump = new Jump(Operation.GOTO);
			code.instructions.add(0, jump);
			code.shortJumps.add(jump);
		}
		Jump jump = new Jump(Operation.GOTO);
		code.instructions.add(jump);
		code.longJumps.add(jump);
		return code;
	}

	public InstructionSequence wrapWithIfClause(Variable conditionVar, InstructionSequence code) throws IllegalArgumentException {
		Conditional condition = new Conditional(Operation.IFFALSE, conditionVar);
		code.instructions.add(0, condition);
		code.shortJumps.add(condition);
		
		Jump jump = new Jump(Operation.GOTO);
		code.instructions.add(jump);
		code.longJumps.add(jump);
		
		return code;
	}
	
	public SingleVariableStub wrapWithWhenClause(ArrayList<WhenCondition> conditions, InstructionSequence block) {
		WhenCondition overallCheck = conditions.get(0);
		for (int i = 1; i < conditions.size(); i++) {
			overallCheck.append(conditions.get(i));
		}
		SingleVariableStub result = overallCheck.getWhenClause(block);
		Jump exitJump = new Jump(Operation.GOTO);
		result.addInstruction(exitJump);
		result.longJumps.add(exitJump);
		return result;
	}
	
	public InstructionSequence createInspect(ExpressionStub inspectedExpression, SingleVariableStub whenParts, InstructionSequence elsePart) throws IllegalArgumentException {
		ExpressionSequence expressionSequence = generateExpression(inspectedExpression);
		if (expressionSequence.result instanceof Variable) {
			InstructionSequence effectiveWhenParts = whenParts.substitute((Variable) expressionSequence.result);
			whenParts.moveLongJumps();
			expressionSequence.append(effectiveWhenParts);
			if (elsePart != null) {
				expressionSequence.append(elsePart);
			}
			return expressionSequence;
		} else {
			throw new IllegalArgumentException("Expected variable in inspect part");
		}
	}

	private VariablesPool variablePool = new VariablesPool();
	LabelsPool labelPool = new LabelsPool();
	private ConstantsPool constants = new ConstantsPool();

	private ArrayList<IntermediateInstruction> instructions = new ArrayList<>();

	private static class SingletonHolder {
		public static final IntermediateCodeGenerator INSTANCE = new IntermediateCodeGenerator();
	}

	public ArrayList<IntermediateInstruction> getCode() {
		return instructions;
	}

	public ConstantsPool getStatics() {
		return constants;
	}
}
