package com.hack.token;

import com.hack.HackInstruction;
import com.hack.SymbolTable;

import java.util.regex.Matcher;

public class Label extends Token {
    public String getLabel() {
        return label;
    }

    private final String label;
    public Label(Matcher matcher) {
        label = matcher.group(1);
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public HackInstruction toHackInstruction(SymbolTable symbolTable) {
        return null;
    }
}
