package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Label;

public class StubLabel extends Label {
	public StubLabel() {
		super(PLACEHOLDER);
	}
	
	@Override
	public String toString() {
		if (effectiveLabel != null) {
			return effectiveLabel.toString();
		}
		return super.toString();
	};
	
	public void setEffectiveLabel(Label label) {
		effectiveLabel = label;
	}
	
	private Label effectiveLabel = null;
	private static final String PLACEHOLDER = "__PLACEHOLDER";
}
