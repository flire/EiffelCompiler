package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.BinaryOperator
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation
import java.util.ArrayList
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Conditional
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.ComparisonConditional

public class WhenInterval(val start: Symbol, val end: Symbol): WhenCondition() {
    override val instructions = createInstructions()

    fun createInstructions(): SingleVariableStub {
        val result = SingleVariableStub()
        val lowerJump = ComparisonConditional(result.placeholder, start, Operation.IFLESS)
        result.addInstruction(lowerJump)
        result.longJumps.add(lowerJump)

        val upperJump = ComparisonConditional(result.placeholder, end, Operation.IFGREATER)
        result.addInstruction(upperJump)
        result.longJumps.add(upperJump)

        return result
    }
}