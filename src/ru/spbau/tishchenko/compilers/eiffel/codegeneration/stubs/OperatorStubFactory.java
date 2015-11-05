package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.BinaryOperator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Conditional;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.UnaryOperator;

public class OperatorStubFactory {
	public static BinaryStub getRegularBinaryOperation(Operation operation) {
		BinaryStub result = new BinaryStub();
		result.addInstruction(new BinaryOperator(result.resultPlaceholder, operation, result.firstArgPlaceholder,
				result.secondArgPlaceholder));
		return result;
	}
	
	public static BinaryStub getAndThenOperation() {
		return getShortCurcuitExpression(Operation.AND, Operation.IFFALSE);
	}
	
	public static BinaryStub getOrElseOperation() {
		return getShortCurcuitExpression(Operation.OR, Operation.IF);
	}
	
	public static UnaryStub getRegularUnaryOperation(Operation operation) {
		UnaryStub result = new UnaryStub();
		result.addInstruction(new UnaryOperator(result.resultPlaceholder, operation, result.argPlaceholder));
		return result;
	}
	
	public static UnaryStub getUnaryPlusStub() {
		UnaryStub result = new UnaryStub();
		result.addInstruction(new Assignment(result.resultPlaceholder, result.argPlaceholder));
		return result;
	}
	
	//TODO: support power operator

	private static BinaryStub getShortCurcuitExpression(Operation operation, Operation jumpCondition) {
		BinaryStub result = new BinaryStub();
		result.addInstruction(
				new Assignment(result.resultPlaceholder, result.firstArgPlaceholder)); // res := a1
		result.addStubJump(
				new Conditional(jumpCondition,
						result.firstArgPlaceholder)); // jmp a1 L
		result.addInstruction(
				new BinaryOperator(result.resultPlaceholder,
						operation,
						result.firstArgPlaceholder,
						result.secondArgPlaceholder));//res := a1 op a2
		return result;
	}

	public static OperatorStub getImpliesOperation() {
		BinaryStub result = new BinaryStub();
		result.addInstruction(new UnaryOperator(result.resultPlaceholder, Operation.NOT, result.firstArgPlaceholder));
		result.addStubJump(
				new Conditional(Operation.IF,
						result.firstArgPlaceholder)); // jmp a1 L
		result.addInstruction(
				new BinaryOperator(result.resultPlaceholder,
						Operation.OR,
						result.firstArgPlaceholder,
						result.secondArgPlaceholder));//res := a1 op a2
		return result;
	}
}
