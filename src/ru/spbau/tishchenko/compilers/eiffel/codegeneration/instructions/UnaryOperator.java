package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class UnaryOperator extends IntermediateInstruction {
	public final Variable arg;
	public final Variable result;

	public UnaryOperator(Variable result, Operation operation, Variable arg) {
		super(operation);
		this.result = result;
		this.arg = arg;
	}

	@Override
	protected Object[] getRepresentation() {
		return new Object[] { result, ASSIGN, operation, arg };
	}

	private final static String ASSIGN = ":=";
}
