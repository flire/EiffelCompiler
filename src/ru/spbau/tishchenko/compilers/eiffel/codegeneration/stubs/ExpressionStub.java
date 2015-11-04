package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;

public class ExpressionStub {
	private final ArrayList<IntermediateInstruction> instructions;
	private final boolean isLabelNeeded;
	final StubVariable resultPlaceholder;

	ExpressionStub(OperatorStub operatorStub) {
		this.instructions = operatorStub.instructions;
		this.resultPlaceholder = operatorStub.resultPlaceholder;
		this.isLabelNeeded = operatorStub.isLabelAfterNeeded;
	}
	
	ExpressionStub()  {
		instructions = new ArrayList<>();
		isLabelNeeded = false;
		resultPlaceholder = new StubVariable();
	}
	
	public InstructionSequence setResult(Variable result) {
		resultPlaceholder.setEffectiveVariable(result);
		return new InstructionSequence(instructions, isLabelNeeded);
	}
	
	public static ExpressionStub StubWithVariable(Variable variable) {
		ExpressionStub result = new ExpressionStub();
		IntermediateInstruction assignment = new Assignment(result.resultPlaceholder, variable);
		result.instructions.add(assignment);
		return result;
	}
}
