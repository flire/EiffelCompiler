package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

public class LabelsPool {
	private int labelCounter = 0;
	
	private static final String LABEL_LITERAL = "L";
	
	public Label getLabel() {
		Label result = new Label(LABEL_LITERAL + Integer.toString(labelCounter));
		labelCounter++;
		return result;
	}
}
