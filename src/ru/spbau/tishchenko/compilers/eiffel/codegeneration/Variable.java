package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class Variable implements Symbol {
	private final String name;
	public Variable(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
