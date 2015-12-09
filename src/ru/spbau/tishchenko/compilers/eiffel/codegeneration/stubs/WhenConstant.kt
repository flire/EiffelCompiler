package ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Variable
import java.util.ArrayList
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Jump
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.Conditional
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.BinaryOperator
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.InstructionSequence
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.stubs.ExpressionStub
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions.ComparisonConditional

public class WhenConstant(val value: Symbol): WhenCondition() {
    override val instructions = createInstructions()

    fun createInstructions(): SingleVariableStub {
        val result = SingleVariableStub()
        val jump = ComparisonConditional(result.placeholder, value, Operation.IFNEQ)
        result.addInstruction(jump)
        result.longJumps.add(jump);
        return result
    }
}