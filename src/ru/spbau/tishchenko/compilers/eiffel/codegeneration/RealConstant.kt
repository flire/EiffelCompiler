package ru.spbau.tishchenko.compilers.eiffel.codegeneration

public class RealConstant(val value: Double): Symbol {
    override fun toString() = value.toString();
}