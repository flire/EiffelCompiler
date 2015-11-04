package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;

public class UnaryOperator extends Operator {

	public UnaryOperator(Operation operation) {
		super(operation);
	}

	@Override
	public OperatorStub getStub() {
		return OperatorStubFactory.getRegularUnaryOperation(operation);
	}
	
	static abstract class Special extends Operator {
		public Special(Operation operation) {
			super(operation);
		}

		public abstract OperatorStub getStub();
	}
}
