package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;

abstract public class OperatorStub {
	protected final StubVariable resultPlaceholder;
	protected final ArrayList<IntermediateInstruction> instructions;
	protected final boolean isLabelAfterNeeded;
	
	OperatorStub(boolean isLabelAfterNeeded) {
		resultPlaceholder = new StubVariable();
		instructions = new ArrayList<>();
		this.isLabelAfterNeeded = isLabelAfterNeeded;
	}

	protected void addInstruction(IntermediateInstruction instruction) {
		instructions.add(instruction);
	}
}
