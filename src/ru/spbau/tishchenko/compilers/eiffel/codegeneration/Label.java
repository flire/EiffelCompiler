package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class Label {

	protected Label(String labelName) {
		this.name = labelName;
	}

	public String toString() {
		return name;
	}
	
	public static final Label NONE = new Label("");
	
	private String name;
}
