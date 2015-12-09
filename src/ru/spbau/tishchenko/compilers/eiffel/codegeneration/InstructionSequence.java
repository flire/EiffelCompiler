package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump;

public class InstructionSequence {
	protected ArrayList<IntermediateInstruction> instructions;
	protected ArrayList<Jump> shortJumps;
	public ArrayList<Jump> longJumps;

	public InstructionSequence(InstructionSequence code) {
		instructions = new ArrayList<>(code.instructions);
		shortJumps = new ArrayList<>(code.shortJumps);
		longJumps = new ArrayList<>(code.longJumps);
	}
	
	public InstructionSequence() {
		instructions = new ArrayList<>();
		shortJumps = new ArrayList<>();
		longJumps = new ArrayList<>();
	}
	
	void resolveShortJumps(Label label) {
		for (Jump jump: shortJumps) {
			jump.setJumpLabel(label);
		}
		shortJumps.clear();
	}
	
	public void moveLongJumps() {
		shortJumps.addAll(longJumps);
		longJumps.clear();
	}
	
	public InstructionSequence append(InstructionSequence other) {
		if (isLabelAfterNeeded()) {
			Label label = IntermediateCodeGenerator.getInstance().labelPool.getLabel();
			resolveShortJumps(label);
			other.instructions.get(0).setLabel(label);
		}
		if (other.isLabelAfterNeeded()) {
			shortJumps.addAll(other.shortJumps);
		}
		instructions.addAll(other.instructions);
		longJumps.addAll(other.longJumps);
		return this;
	}
	
	public void addInstruction(IntermediateInstruction instruction) {
		instructions.add(instruction);
	}
	
	public void appendWithoutResolving(InstructionSequence code) {
		instructions.addAll(code.instructions);
		shortJumps.addAll(code.shortJumps);
		longJumps.addAll(code.longJumps);
	}
	
	public InstructionSequence insertPreceedingCode(InstructionSequence preceeding) {
		if (preceeding.isLabelAfterNeeded()) {
			Label label = IntermediateCodeGenerator.getInstance().labelPool.getLabel();
			preceeding.resolveShortJumps(label);
			instructions.get(0).setLabel(label);
		}
		instructions.addAll(0, preceeding.instructions);
		longJumps.addAll(preceeding.longJumps);
		return this;
	}
	
	public ArrayList<IntermediateInstruction> getInstructions() {
		return instructions;
	}

	public boolean isLabelAfterNeeded() {
		return !shortJumps.isEmpty();
	}
}