package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class BinaryStub extends OperatorStub {
	final StubVariable firstArgPlaceholder = new StubVariable();
	final StubVariable secondArgPlaceholder = new StubVariable();
	
	public ExpressionStub setArguments(Variable firstArg, Variable secondArg) {
		firstArgPlaceholder.setEffectiveVariable(firstArg);
		secondArgPlaceholder.setEffectiveVariable(secondArg);
		return new ExpressionStub(this);
	}
}