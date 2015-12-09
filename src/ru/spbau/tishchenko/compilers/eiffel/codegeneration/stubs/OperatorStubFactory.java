package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Assignment;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.BinaryOperator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.UnaryOperator;

public class OperatorStubFactory {
	public static ExpressionStub getRegularBinaryOperation(Operation operation, Symbol arg1, Symbol arg2) {
		ExpressionStub result = new ExpressionStub();
		result.addInstruction(new BinaryOperator(result.resultPlaceholder, operation, arg1, arg2));
		return result;
	}
	
	public static ExpressionStub getAndThenOperation(Symbol arg1, Symbol arg2) {
		return getShortCurcuitExpression(Operation.AND, Operation.IFFALSE, arg1, arg2);
	}
	
	public static ExpressionStub getOrElseOperation(Symbol arg1, Symbol arg2) {
		return getShortCurcuitExpression(Operation.OR, Operation.IF, arg1, arg2);
	}
	
	public static ExpressionStub getRegularUnaryOperation(Operation operation, Symbol arg) {
		ExpressionStub result = new ExpressionStub();
		result.addInstruction(new UnaryOperator(result.resultPlaceholder, operation, arg));
		return result;
	}
	
	public static ExpressionStub getUnaryPlusStub(Symbol arg) {
		ExpressionStub result = new ExpressionStub();
		result.addInstruction(new Assignment(result.resultPlaceholder, arg));
		return result;
	}
	
	//TODO: support power operator

	private static ExpressionStub getShortCurcuitExpression(Operation operation, Operation jumpCondition, Symbol arg1, Symbol arg2) {
		ExpressionStub result = new ExpressionStub();
		result.addInstruction(
				new Assignment(result.resultPlaceholder, arg1)); // res := a1
		result.addStubJump(IntermediateCodeGenerator.getInstance().jumpWithSymbol(operation, arg1));
		result.addInstruction(
				new BinaryOperator(result.resultPlaceholder,
						operation,
						arg1,
						arg2));//res := a1 op a2
		return result;
	}

	public static ExpressionStub getImpliesOperation(Symbol arg1, Symbol arg2) {
		ExpressionStub result = new ExpressionStub();
		result.addInstruction(new UnaryOperator(result.resultPlaceholder, Operation.NOT, arg1));
		result.addStubJump(IntermediateCodeGenerator.getInstance().jumpWithSymbol(Operation.IF, arg1)); // jmp a1 L
		result.addInstruction(
				new BinaryOperator(result.resultPlaceholder,
						Operation.OR,
						arg1,
						arg2));//res := a1 op a2
		return result;
	}
}
