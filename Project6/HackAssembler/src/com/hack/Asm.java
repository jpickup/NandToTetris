package com.hack;

import com.hack.token.Token;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class Asm {
    private Parser parser;
    private SymbolTable symbolTable;
    private Assembler assembler;
    private boolean debug = false;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("asm <filename.asm>");
            System.exit(1);
        }
        try {
            Asm asm = new Asm();
            asm.process(new File(args[0]));
        } catch (Exception ex) {
            System.err.println("Error " + ex.getMessage());
        }
    }

    Asm() {
        parser = new Parser();
        symbolTable = new SymbolTable();
        assembler = new Assembler();
    }

    private void process(File assemblerFile) throws Exception {
        if (!assemblerFile.canRead()) throw new RuntimeException("Cannot read " + assemblerFile.getAbsolutePath());
        if (!assemblerFile.getName().endsWith(".asm")) throw new RuntimeException(assemblerFile.getAbsolutePath() + " is not a .asm file");
        File outfile = new File(assemblerFile.getParent(), assemblerFile.getName().replace(".asm", ".hack"));
        System.out.printf("Assembling %s%n", assemblerFile.getAbsolutePath());

        List<Token> tokens = parser.parse(assemblerFile);
        if (debug) {
            tokens.forEach(System.out::println);
            System.out.println(tokens.size());
        }

        symbolTable.build(tokens);
        if (debug) System.out.println(symbolTable);

        List<HackInstruction> hackInstructions = assembler.assemble(tokens, symbolTable);
        if (debug) hackInstructions.forEach(h -> System.out.println(h.asBinaryText()));

        List<String> outputLines = hackInstructions.stream().map(HackInstruction::asBinaryText).collect(Collectors.toList());
        Files.write(outfile.toPath(), outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        System.out.printf("Wrote hack output to %s (%d instructions)%n", outfile.getAbsolutePath(), hackInstructions.size());
    }
}