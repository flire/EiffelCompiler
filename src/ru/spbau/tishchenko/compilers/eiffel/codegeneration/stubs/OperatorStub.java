package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

abstract public class OperatorStub extends InstructionSequence {
	protected final StubVariable resultPlaceholder;
	
	OperatorStub() {
		resultPlaceholder = new StubVariable();
	}
	
	protected void addStubJump(Jump jump) {
		if (jump != null) {
			shortJumps.add(jump);
			addInstruction(jump);
		}
	}
}
