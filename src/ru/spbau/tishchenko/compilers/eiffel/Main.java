package ru.spbau.tishchenko.compilers.eiffel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
		} catch (FileNotFoundException e) {
			System.err.println("File not found "+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unknown IO error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void printUsage() {
		System.out.println("eiffel file.txt");
		
	}
}
