package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

public class InstructionSequence {
	protected ArrayList<IntermediateInstruction> instructions;
//	protected boolean isLabelAfterNeeded;
	protected ArrayList<Jump> instructionsToResolveWithLabel;// = new ArrayList<>();

	public InstructionSequence(InstructionSequence code) {
		instructions = new ArrayList<>(code.instructions);
		instructionsToResolveWithLabel = new ArrayList<>(code.instructionsToResolveWithLabel);
//		this.isLabelAfterNeeded = isLabelAfterNeeded;
	}
	
	public InstructionSequence() {
		instructions = new ArrayList<>();
//		isLabelAfterNeeded = false;
		instructionsToResolveWithLabel = new ArrayList<>();
	}
	
	
	
	void resolveLabels(Label label) {
//		for (IntermediateInstruction instr: instructions) {
//			if (instr instanceof Jump) {
//				((Jump) instr).setJumpLabel(label);
//			}
//		}
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

//	public void append(InstructionSequence other, Label label) {
//		resolveLabels(label);
//		other.instructions.get(0).setLabel(label);
//		append(other);
//	}
	
	public boolean isLabelAfterNeeded() {
		return !instructionsToResolveWithLabel.isEmpty();
	}
}