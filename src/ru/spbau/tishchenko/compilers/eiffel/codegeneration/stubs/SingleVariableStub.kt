package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence
import java.util.ArrayList
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable

public open class SingleVariableStub 
	protected constructor(val placeholder: StubVariable): InstructionSequence() {
    constructor(): this(StubVariable())
    constructor(other: SingleVariableStub): this(other.placeholder) {
        appendWithoutResolving(other)
        appendedPlaceholders.addAll(other.appendedPlaceholders)
    }
    
    protected val appendedPlaceholders: ArrayList<StubVariable> = ArrayList<StubVariable>()
    
    public fun substitute(arg: Variable): InstructionSequence {
    	placeholder.setEffectiveVariable(arg)
        for (appended in appendedPlaceholders) {
            appended.setEffectiveVariable(arg)
        }
    	return this
    }
    
    public fun appendWithoutResolving(other: SingleVariableStub) {
        appendWithoutResolving(other as InstructionSequence)
        appendedPlaceholders.add(other.placeholder)
        appendedPlaceholders.addAll(other.appendedPlaceholders)
    }
    
    public fun append(other: SingleVariableStub) {
        append(other as InstructionSequence)
        appendedPlaceholders.add(other.placeholder)
        appendedPlaceholders.addAll(other.appendedPlaceholders)
    }
}