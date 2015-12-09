package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump
import java.util.ArrayList
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator

public abstract class WhenCondition {
    abstract protected val instructions: SingleVariableStub
    
    fun getWhenClause(operators: InstructionSequence): SingleVariableStub {
        val code = instructions
        code.appendWithoutResolving(operators)
        code.moveLongJumps()
        return code
    }
    
    fun append(condition: WhenCondition) {
        instructions.append(condition.instructions)
    }
}