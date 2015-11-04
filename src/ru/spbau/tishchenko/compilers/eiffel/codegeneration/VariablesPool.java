package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class VariablesPool {
	private int localCounter = 0;
	private int staticCounter = 0;
	
	private static final String LOCAL_LITERAL = "l";
	private static final String STATIC_LITERAL = "s";
	
	public Variable getLocalVariable() {
		Variable result = new Variable(LOCAL_LITERAL + Integer.toString(localCounter));
		localCounter++;
		return result;
	}
	
	public Variable getStaticVariable() {
		Variable result = new Variable(STATIC_LITERAL + Integer.toString(staticCounter));
		staticCounter++;
		return result;
	}
}
