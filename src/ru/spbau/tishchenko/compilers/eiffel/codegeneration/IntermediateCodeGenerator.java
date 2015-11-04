package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;
import ru.spbau.tishchenko.compilers.eiffel.language.Operator;

public class IntermediateCodeGenerator {
		
	public static IntermediateCodeGenerator getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public void appendCode(InstructionSequence code) {
		if (labelForNextInstruction != null) {
			code.instructions.get(0).setLabel(labelForNextInstruction);
			labelForNextInstruction = null;
		}
		if (code.isLabelAfterNeeded) {
			labelForNextInstruction = labelPool.getLabel();
			code.resolveLabels(labelForNextInstruction);
		}
		instructions.addAll(code.instructions);
	}
	
	public Variable appendExpression(ExpressionStub expression) {
		Variable expressionResult = variablePool.getLocalVariable();
		InstructionSequence expressionCode = expression.setResult(expressionResult);
		appendCode(expressionCode);
		return expressionResult;
	}
	
	public ExpressionStub bindConstant(Object constant) {
		Variable constantVar = variablePool.getStaticVariable();
		constants.addConstant(constantVar, constant);
		return ExpressionStub.StubWithVariable(constantVar);
	}
	
	private VariablesPool variablePool = new VariablesPool();
	private LabelsPool labelPool = new LabelsPool();
	private ConstantsPool constants = new ConstantsPool();
	
	private ArrayList<IntermediateInstruction> instructions = new ArrayList<>();

	private static class SingletonHolder {
		public static final IntermediateCodeGenerator INSTANCE = new IntermediateCodeGenerator();
	}
	
	private Label labelForNextInstruction = null;

	public ArrayList<IntermediateInstruction> getCode() {
		return instructions;
	}
	
	
}
