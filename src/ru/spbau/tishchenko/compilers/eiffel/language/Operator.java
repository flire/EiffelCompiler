package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub;
import ru.spbau.tishchenko.compilers.eiffel.language.BinaryOperator;

public abstract class Operator {
	public final Operation operation;
	
	public Operator(Operation operation) {
		this.operation = operation;
	}
	
	public final static BinaryOperator PLUS = new BinaryOperator(Operation.ADD);
	public final static BinaryOperator MINUS = new BinaryOperator(Operation.SUB);
	public final static BinaryOperator MULT = new BinaryOperator(Operation.MUL);
	public final static BinaryOperator IDIV = new BinaryOperator(Operation.DIV);
	public final static BinaryOperator RDIV = new BinaryOperator(Operation.RDIV);
	public final static BinaryOperator MOD = new BinaryOperator(Operation.MOD);
	
	public final static BinaryOperator EQ = new BinaryOperator(Operation.EQ);
	public final static BinaryOperator GT = new BinaryOperator(Operation.GT);
	public final static BinaryOperator LT = new BinaryOperator(Operation.LT);
	public final static BinaryOperator GEQ = new BinaryOperator(Operation.GEQ);
	public final static BinaryOperator LEQ = new BinaryOperator(Operation.LEQ);
	
	public final static BinaryOperator AND = new BinaryOperator(Operation.AND);
	public final static BinaryOperator OR = new BinaryOperator(Operation.OR);
	public final static BinaryOperator XOR = new BinaryOperator(Operation.XOR);
	
	public final static BinaryOperator ANDTHEN = new BinaryOperator.Special(Operation.AND) {
		@Override
		public ExpressionStub getStub(Symbol arg1, Symbol arg2) {
			return OperatorStubFactory.getAndThenOperation(arg1, arg2);
		}
	};
	public final static BinaryOperator ORELSE = new BinaryOperator.Special(Operation.OR) {
		@Override
		public ExpressionStub getStub(Symbol arg1, Symbol arg2) {
			return OperatorStubFactory.getOrElseOperation(arg1, arg2);
		}
	};
	
	public final static BinaryOperator IMPLIES = new BinaryOperator.Special(Operation.OR) {
		@Override
		public ExpressionStub getStub(Symbol arg1, Symbol arg2) {
			return OperatorStubFactory.getImpliesOperation(arg1, arg2);
		}
		
	};
	
	public final static UnaryOperator NEG = new UnaryOperator(Operation.NEG);
	public final static UnaryOperator NOT = new UnaryOperator(Operation.NOT);
	public final static UnaryOperator UNARY_PLUS = new UnaryOperator.Special(Operation.ADD) {
		@Override
		public ExpressionStub getStub(Symbol arg1) {
			return OperatorStubFactory.getUnaryPlusStub(arg1);
		}
	};
}
