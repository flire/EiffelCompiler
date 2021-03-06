package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class UnaryStub extends OperatorStub{

	final StubVariable argPlaceholder = new StubVariable();
	
	public ExpressionStub setArgument(Variable arg) {
		argPlaceholder.setEffectiveVariable(arg);
		return new ExpressionStub(this);
	}
}
