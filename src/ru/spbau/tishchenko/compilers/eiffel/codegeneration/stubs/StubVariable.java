package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable;

public class StubVariable extends Variable {
	public StubVariable() {
		super(PLACEHOLDER);
		this.effectiveVar = null;
	}
	
	private StubVariable(Variable effective) {
		super(PLACEHOLDER);
		this.effectiveVar = effective;
	}
	
	protected StubVariable(StubVariable other) {
		this(other.effectiveVar);
	}
	
	@Override
	public String toString() {
		if (effectiveVar != null) {
			return effectiveVar.toString();
		}
		return super.toString();
	};
	
	public void setEffectiveVariable(Variable variable) {
		effectiveVar = variable;
	}
	
	protected Variable getEffectiveVar() {
		return effectiveVar;
	}
	
	private Variable effectiveVar = null;
	
	private static final String PLACEHOLDER = "__PLACEHOLDER";
}
