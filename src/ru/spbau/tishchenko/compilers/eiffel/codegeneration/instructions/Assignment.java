package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class Assignment extends IntermediateInstruction {
	
	public final Variable result;
	public final Symbol arg;
	
	public Assignment(Variable result, Symbol arg) {
		super(Operation.ASSIGN);
		this.result = result;
		this.arg = arg;
	}

	@Override
	protected Object[] getRepresentation() {
		return new Object[] {result, ":=", arg};
	}


}
