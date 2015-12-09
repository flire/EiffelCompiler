package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.ExpressionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;

public class BinaryOperator extends Operator {

	public BinaryOperator(Operation operation) {
		super(operation);
	}
	
	public ExpressionStub getStub(ExpressionStub arg1, ExpressionStub arg2) {
		ExpressionSequence expr1 = IntermediateCodeGenerator.getInstance().generateExpression(arg1);
		ExpressionSequence expr2 = IntermediateCodeGenerator.getInstance().generateExpression(arg2);
		return getStub(expr1, expr2);
	}
	
	public ExpressionStub getStub(ExpressionSequence arg1, ExpressionSequence arg2) {
		ExpressionStub result = getStub(arg1.result, arg2.result);
		result.insertPreceedingCode(arg2.insertPreceedingCode(arg1));
		return result;
	}

	public ExpressionStub getStub(Symbol arg1, Symbol arg2) {
		return OperatorStubFactory.getRegularBinaryOperation(operation, arg1, arg2);
	}

	static abstract class Special extends BinaryOperator {
		public Special(Operation operation) {
			super(operation);
		}

		@Override
		public abstract ExpressionStub getStub(Symbol arg1, Symbol arg2);
	}
}