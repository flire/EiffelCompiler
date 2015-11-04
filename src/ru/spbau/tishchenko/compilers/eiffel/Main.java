package ru.spbau.tishchenko.compilers.eiffel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateCodeGenerator;
import ru.spbau.tishchenko.compilers.eiffel.codegeneration.IntermediateInstruction;
import ru.spbau.tishchenko.compilers.eiffel.parser.Eiffel;
import ru.spbau.tishchenko.compilers.eiffel.parser.EiffelLexer;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			printUsage();
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(args[0]);
			EiffelLexer lexer = new EiffelLexer(fis);
			Eiffel parser = new Eiffel(lexer);
			parser.parse();
			ArrayList<IntermediateInstruction> intermediateCode = IntermediateCodeGenerator.getInstance().getCode();
			printToOut(intermediateCode);
		} catch (FileNotFoundException e) {
			System.err.println("File not found "+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unknown IO error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void printToOut(ArrayList<IntermediateInstruction> intermediateCode) {
		for(IntermediateInstruction instr: intermediateCode) {
			System.out.println(instr);
		}
	}

	private static void printUsage() {
		System.out.println("eiffel file.txt");
		
	}
}
