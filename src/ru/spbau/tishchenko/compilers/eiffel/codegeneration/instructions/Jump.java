package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Label;

public class Jump extends IntermediateInstruction {
	
	protected Label labelToJump;

	public Jump(Operation operation) {
		this(operation, Label.NONE);
	}
	
	public Jump(Operation operation, Label label) {
		super(operation);
		this.labelToJump = label;
	}

	@Override
	protected Object[] getRepresentation() {
		return new Object[] {operation, labelToJump};
	}
	
	public void setJumpLabel(Label label) {
		if (labelToJump.equals(Label.NONE)) {
			labelToJump = label;
		}
	}
}
