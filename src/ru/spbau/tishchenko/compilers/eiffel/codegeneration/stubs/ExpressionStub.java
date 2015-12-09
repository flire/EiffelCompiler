package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.ExpressionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

public class ExpressionStub extends InstructionSequence {
	final StubVariable resultPlaceholder;

	ExpressionStub(OperatorStub operatorStub) {
		super(operatorStub);
		this.resultPlaceholder = operatorStub.resultPlaceholder;
	}
	
	ExpressionStub()  {
		resultPlaceholder = new StubVariable();
	}
	
	public boolean isVariableNeeded() {
		return true;
	}
	
	public void setResult(Variable result) {
		resultPlaceholder.setEffectiveVariable(result);
	}
	
	public ExpressionSequence getExpression() {
		return new ExpressionSequence(this, resultPlaceholder.getEffectiveVar());
	}
	
	public InstructionSequence assignTo(Variable var) {
		setResult(var);
		return getExpression();
	}
	
	public static ExpressionStub StubWithVariable(Variable variable) {
		ExpressionStub result = new ExpressionStub();
		IntermediateInstruction assignment = new Assignment(result.resultPlaceholder, variable);
		result.instructions.add(assignment);
		return result;
	}
	
	protected void addStubJump(Jump jump) {
		if (jump != null) {
			shortJumps.add(jump);
			addInstruction(jump);
		}
	}
}
