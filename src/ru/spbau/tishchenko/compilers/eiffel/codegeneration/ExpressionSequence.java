package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;

public class ExpressionSequence extends InstructionSequence {

	public final Variable result;

	public ExpressionSequence(ExpressionStub expressionStub, Variable result) {
		super(expressionStub);
		this.result = result;
	}

}
