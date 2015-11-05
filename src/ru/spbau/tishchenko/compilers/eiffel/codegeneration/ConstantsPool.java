package ru.spbau.tishchenko.compilers.eiffel.codegeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConstantsPool {
	private HashMap<Variable, Object> constants = new HashMap<>();
	
	void addConstant(Variable variable, Object object) {
		constants.put(variable, object);
	}
	
	public ArrayList<String> getConstantsTable() {
		ArrayList<String> result = new ArrayList<>();
		for (Map.Entry<Variable, Object> entry : constants.entrySet()) {
			result.add(entry.getKey().toString() + ": " + entry.getValue().toString());
		}
		return result;
	}
}
