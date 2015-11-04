package ru.spbau.tishchenko.compilers.eiffel.language;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStubFactory;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.OperatorStub;
import ru.spbau.tishchenko.compilers.eiffel.language.BinaryOperator;

public abstract class Operator {
	public final Operation operation;
	
	public Operator(Operation operation) {
		this.operation = operation;
	}
	public abstract OperatorStub getStub();
	
	public final static Operator PLUS = new BinaryOperator(Operation.ADD);
	public final static Operator MINUS = new BinaryOperator(Operation.SUB);
	public final static Operator MULT = new BinaryOperator(Operation.MUL);
	public final static Operator IDIV = new BinaryOperator(Operation.DIV);
	public final static Operator RDIV = new BinaryOperator(Operation.RDIV);
	public final static Operator MOD = new BinaryOperator(Operation.MOD);
	
	public final static Operator EQ = new BinaryOperator(Operation.EQ);
	public final static Operator GT = new BinaryOperator(Operation.GT);
	public final static Operator LT = new BinaryOperator(Operation.LT);
	public final static Operator GEQ = new BinaryOperator(Operation.GEQ);
	public final static Operator LEQ = new BinaryOperator(Operation.LEQ);
	
	public final static Operator AND = new BinaryOperator(Operation.AND);
	public final static Operator OR = new BinaryOperator(Operation.OR);
	public final static Operator XOR = new BinaryOperator(Operation.XOR);
	
	public final static Operator ANDTHEN = new BinaryOperator.Special(Operation.AND) {
		@Override
		public OperatorStub getStub() {
			return OperatorStubFactory.getAndThenOperation();
		}
	};
	public final static Operator ORELSE = new BinaryOperator.Special(Operation.OR) {
		@Override
		public OperatorStub getStub() {
			return OperatorStubFactory.getOrElseOperation();
		}
	};
	
	public final static Operator IMPLIES = new BinaryOperator.Special(Operation.OR) {
		@Override
		public OperatorStub getStub() {
			return OperatorStubFactory.getImpliesOperation();
		}
		
	};
	
	public final static Operator NEG = new UnaryOperator(Operation.NEG);
	public final static Operator NOT = new UnaryOperator(Operation.NOT);
	public final static Operator UNARY_PLUS = new UnaryOperator.Special(Operation.ADD) {
		@Override
		public OperatorStub getStub() {
			return OperatorStubFactory.getUnaryPlusStub();
		}
	};
}
