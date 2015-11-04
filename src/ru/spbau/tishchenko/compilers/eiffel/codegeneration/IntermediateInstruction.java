package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class IntermediateInstruction {
	public static enum Operation {
		ASSIGN,
		
		ADD,
		SUB,
		MUL,
		DIV,
		MOD,
		RDIV,
		NEG,
		
		AND,
		OR,
		NOT,
		XOR,
		
		EQ,
		LEQ,
		GEQ,
		LT,
		GT,
		
		PARAM,
		INVOKE,
		
		IF,
		IFFALSE,
		GOTO
	}

	public IntermediateInstruction(Operation operation) {
		this.operation = operation;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	
	public String toString() {
		return appendLabelIfExists(
				Arrays.stream(getRepresentation())
				.map(Object::toString)
				.collect(Collectors.joining(" ")));
	}
	
	private String appendLabelIfExists(String representation) {
		if (label.equals(Label.NONE)) {
			return representation;
		}
		String result = label.toString() + ": " + representation;
		return result;
	}
	
	protected abstract Object[] getRepresentation();
	
	public final Operation operation;
	private Label label = Label.NONE;
}
