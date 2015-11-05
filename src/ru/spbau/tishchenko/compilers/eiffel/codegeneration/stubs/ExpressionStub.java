package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.ExpressionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;

public class ExpressionStub extends InstructionSequence {
//	private final ArrayList<IntermediateInstruction> instructions;
//	private final boolean isLabelNeeded;
	final StubVariable resultPlaceholder;

	ExpressionStub(OperatorStub operatorStub) {
		super(operatorStub);
//		this.instructions = operatorStub.instructions;
		this.resultPlaceholder = operatorStub.resultPlaceholder;
	}
	
	ExpressionStub()  {
		resultPlaceholder = new StubVariable();
	}
	
	public ExpressionSequence setResult(Variable result) {
		resultPlaceholder.setEffectiveVariable(result);
		return new ExpressionSequence(this, result);
	}
	
	public static ExpressionStub StubWithVariable(Variable variable) {
		ExpressionStub result = new ExpressionStub();
		IntermediateInstruction assignment = new Assignment(result.resultPlaceholder, variable);
		result.instructions.add(assignment);
		return result;
	}
//	
//	public void preeceedWith(InstructionSequence preceedingCode) {
//		instructions.addAll(0, preceedingCode.getInstructions());
//	}
}
