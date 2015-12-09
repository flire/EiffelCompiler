package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class ExpressionSequence extends InstructionSequence {

	public final Symbol result;

	public ExpressionSequence(InstructionSequence expressionStub, Symbol result) {
		super(expressionStub);
		this.result = result;
	}

}
