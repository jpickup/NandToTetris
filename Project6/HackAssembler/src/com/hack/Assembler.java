package com.hack;

import com.hack.token.Assignment;
import com.hack.token.Label;
import com.hack.token.Token;

import java.util.List;
import java.util.stream.Collectors;

public class Assembler {
    public List<HackInstruction> assemble(List<Token> tokens, SymbolTable symbolTable) {
        return tokens.stream()
                .filter(t -> !(t instanceof Label))
                .map(t -> toHackInstruction(t, symbolTable))
                .collect(Collectors.toList());
    }

    private HackInstruction toHackInstruction(Token t, SymbolTable symbolTable) {
        return t.toHackInstruction(symbolTable);
    }
}
