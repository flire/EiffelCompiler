package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.ExpressionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;

public class UnaryOperator extends Operator {

	public UnaryOperator(Operation operation) {
		super(operation);
	}
	
	public ExpressionStub getStub(ExpressionStub arg) {
		ExpressionSequence expr = IntermediateCodeGenerator.getInstance().generateExpression(arg);
		return getStub(expr);
	}

	public ExpressionStub getStub(ExpressionSequence arg) {
		ExpressionStub result = getStub(arg.result);
		result.insertPreceedingCode(arg);
		return result;
	}

	public ExpressionStub getStub(Symbol arg) {
		return OperatorStubFactory.getRegularUnaryOperation(operation, arg);
	}
	
	static abstract class Special extends UnaryOperator {
		public Special(Operation operation) {
			super(operation);
		}

		@Override
		public abstract ExpressionStub getStub(Symbol arg);
	}
}
