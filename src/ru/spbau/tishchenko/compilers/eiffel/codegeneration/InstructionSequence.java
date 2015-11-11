package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

public class InstructionSequence {
	protected ArrayList<IntermediateInstruction> instructions;
	protected ArrayList<Jump> instructionsToResolveWithLabel;

	public InstructionSequence(InstructionSequence code) {
		instructions = new ArrayList<>(code.instructions);
		instructionsToResolveWithLabel = new ArrayList<>(code.instructionsToResolveWithLabel);
	}
	
	public InstructionSequence() {
		instructions = new ArrayList<>();
		instructionsToResolveWithLabel = new ArrayList<>();
	}
	
	void resolveLabels(Label label) {
		for (Jump jump: instructionsToResolveWithLabel) {
			jump.setJumpLabel(label);
		}
		instructionsToResolveWithLabel.clear();
	}
	
	public InstructionSequence append(InstructionSequence other) {
		if (isLabelAfterNeeded()) {
			Label label = IntermediateCodeGenerator.getInstance().labelPool.getLabel();
			resolveLabels(label);
			other.instructions.get(0).setLabel(label);
		}
		if (other.isLabelAfterNeeded()) {
			instructionsToResolveWithLabel.addAll(other.instructionsToResolveWithLabel);
		}
		instructions.addAll(other.instructions);
		return this;
	}
	
	public InstructionSequence insertPreceedingCode(InstructionSequence preceeding) {
		if (preceeding.isLabelAfterNeeded()) {
			Label label = IntermediateCodeGenerator.getInstance().labelPool.getLabel();
			preceeding.resolveLabels(label);
			instructions.get(0).setLabel(label);
		}
		instructions.addAll(0, preceeding.instructions);
		return this;
	}
	
	public ArrayList<IntermediateInstruction> getInstructions() {
		return instructions;
	}

	public boolean isLabelAfterNeeded() {
		return !instructionsToResolveWithLabel.isEmpty();
	}
}