package ru.spbau.tishchenko.compilers.eiffel.codegeneration.instructions

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.Symbol
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction.Operation

public class ComparisonConditional(val arg1: Symbol, val arg2: Symbol, val op: Operation): Jump(op) {
    override fun getRepresentation(): Array<Any> = arrayOf(op, arg1, arg2, labelToJump)
}