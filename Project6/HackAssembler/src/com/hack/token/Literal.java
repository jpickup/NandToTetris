package com.hack.token;

import com.hack.HackInstruction;
import com.hack.SymbolTable;

import java.util.Objects;

public class Literal extends Token {
    private final int value;

    public Literal(String s) {
        this.value = Integer.parseInt(s);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Literal literal = (Literal) o;
        return value == literal.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "com.hack.token.Literal{" +
                "value=" + value +
                '}';
    }

    @Override
    public HackInstruction toHackInstruction(SymbolTable symbolTable) {
        HackInstruction hackInstruction = new HackInstruction();
        hackInstruction.setLiteral(value);
        return hackInstruction;
    }
}
