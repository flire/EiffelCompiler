package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;

public class BinaryOperator extends Operator {

	public BinaryOperator(Operation operation) {
		super(operation);
	}

	@Override
	public OperatorStub getStub() {
		return OperatorStubFactory.getRegularBinaryOperation(operation);
	}

	static abstract class Special extends Operator {
		public Special(Operation operation) {
			super(operation);
		}

		public abstract OperatorStub getStub();
	}
}