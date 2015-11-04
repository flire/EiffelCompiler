package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

public class InstructionSequence {
	ArrayList<IntermediateInstruction> instructions;
	final boolean isLabelAfterNeeded;

	public InstructionSequence(ArrayList<IntermediateInstruction> instructionsList, boolean isLabelAfterNeeded) {
		instructions = new ArrayList<>(instructionsList);
		this.isLabelAfterNeeded = isLabelAfterNeeded;
	}
	
	void resolveLabels(Label label) {
		for (IntermediateInstruction instr: instructions) {
			if (instr instanceof Jump) {
				((Jump) instr).setJumpLabel(label);
			}
		}
	}
}