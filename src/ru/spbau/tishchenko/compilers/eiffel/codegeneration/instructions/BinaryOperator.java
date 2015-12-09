package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class BinaryOperator extends IntermediateInstruction {
	public final Symbol arg1;
	public final Symbol arg2;
	public final Variable result;

	public BinaryOperator(Variable result, Operation operation, Symbol arg1, Symbol arg2) {
		super(operation);
		this.result = result;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	@Override
	protected Object[] getRepresentation() {
		return new Object[] { result, ASSIGN, operation, arg1, arg2 };
	}

	private final static String ASSIGN = ":=";

}
