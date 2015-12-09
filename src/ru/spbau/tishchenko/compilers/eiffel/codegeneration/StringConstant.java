package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class StringConstant implements Symbol {
	public final String label;
	
	public StringConstant(String argLabel) {
		label = argLabel;
	}

	public String toString() {
		return label;
	}
}
