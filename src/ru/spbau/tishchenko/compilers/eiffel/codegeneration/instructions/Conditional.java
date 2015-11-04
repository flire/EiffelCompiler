package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class Conditional extends Jump {
	
	public final Variable arg;
	
	public Conditional(Operation operation, Variable arg) {
		super(operation);
		this.arg = arg;
	}

	@Override
	protected Object[] getRepresentation() {
		return new Object[] {operation, arg, labelToJump};
	}

}
