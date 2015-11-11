package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

abstract public class OperatorStub extends InstructionSequence {
	protected final StubVariable resultPlaceholder;
	
	OperatorStub() {
		resultPlaceholder = new StubVariable();
	}

	protected void addInstruction(IntermediateInstruction instruction) {
		instructions.add(instruction);
	}
	
	protected void addStubJump(Jump jump) {
		instructionsToResolveWithLabel.add(jump);
		addInstruction(jump);
	}
}
