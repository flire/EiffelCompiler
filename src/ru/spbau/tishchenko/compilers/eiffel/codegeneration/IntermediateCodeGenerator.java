package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Conditional;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;

public class IntermediateCodeGenerator {
		
	public static IntermediateCodeGenerator getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public void setCode(InstructionSequence code) {
		instructions = code.instructions;
	}
	
//	public InstructionSequence joinCode(InstructionSequence first, InstructionSequence second) {
//		if (first.isLabelAfterNeeded()) {
//			Label label = labelPool.getLabel();
////			first.resolveLabels(label);
////			second.instructions.get(0).setLabel(label);
////			first.isLabelAfterNeeded = false;
//			first.append(second, label);
//		} else {
//			first.append(second);
//		}
//		return first;
////		if (second.isLabelAfterNeeded) {
////			first.isLabelAfterNeeded = true;
////			labelForNextInstruction = labelPool.getLabel();
////			code.resolveLabels(labelForNextInstruction);
////		}
////		instructions.addAll(code.instructions);
//	}
	
	public ExpressionSequence generateExpression(ExpressionStub expression) {
		Variable expressionResult = variablePool.getLocalVariable();
		ExpressionSequence expressionCode = expression.setResult(expressionResult);
		return expressionCode;
	}
	
	public ExpressionStub bindConstant(Object constant) {
		Variable constantVar = variablePool.getStaticVariable();
		constants.addConstant(constantVar, constant);
		return ExpressionStub.StubWithVariable(constantVar);
	}
	
	public InstructionSequence wrapWithIfClause(Variable conditionVar, InstructionSequence code) {
		Conditional condition = new Conditional(Operation.IFFALSE, conditionVar);
		code.instructions.add(0, condition);
		code.instructionsToResolveWithLabel.add(condition);
		return code;
	}
	
	private VariablesPool variablePool = new VariablesPool();
	LabelsPool labelPool = new LabelsPool();
	private ConstantsPool constants = new ConstantsPool();
	
	private ArrayList<IntermediateInstruction> instructions = new ArrayList<>();

	private static class SingletonHolder {
		public static final IntermediateCodeGenerator INSTANCE = new IntermediateCodeGenerator();
	}
	
//	private Label labelForNextInstruction = null;

	public ArrayList<IntermediateInstruction> getCode() {
		return instructions;
	}
	
	public ConstantsPool getStatics() {
		return constants;
	}
}
