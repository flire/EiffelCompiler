package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.HashMap;

public class ConstantsPool {
	private HashMap<Variable, Object> constants = new HashMap<>();
	
	void addConstant(Variable variable, Object object) {
		constants.put(variable, object);
	}
}
