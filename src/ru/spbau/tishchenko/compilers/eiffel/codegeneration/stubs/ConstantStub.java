package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.ExpressionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;

public class ConstantStub extends ExpressionStub {
	private Symbol constant;

	public ConstantStub(Symbol constant) {
		this.constant = constant;
	}
	@Override
	public boolean isVariableNeeded() {
		return false;
	}

	@Override
	public ExpressionSequence getExpression() {
		return new ExpressionSequence(new InstructionSequence(), constant);
	}
	
	@Override
	public InstructionSequence assignTo(Variable var) {
		InstructionSequence result = new InstructionSequence();
		result.addInstruction(new Assignment(var, constant));
		return result;
	}
}
