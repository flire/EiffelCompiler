package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class BoolConstant implements Symbol {
	public final boolean value;
	
	public BoolConstant(boolean argValue) {
		value = argValue;
	}
	
	public String toString() {
		return new Boolean(value).toString();
	}
}
