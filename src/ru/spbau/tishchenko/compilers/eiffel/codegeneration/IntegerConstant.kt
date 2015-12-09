package ru.spbau.tishchenko.compilers.eiffel.codegeneration

public class IntegerConstant(val value: Int): Symbol {
    override fun toString() = value.toString()
}