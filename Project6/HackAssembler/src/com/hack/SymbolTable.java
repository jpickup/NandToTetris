package com.hack;

import com.hack.token.Label;
import com.hack.token.Symbol;
import com.hack.token.Token;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class SymbolTable {
    private final Map<String, Integer> entries;

    public SymbolTable() {
        entries = new TreeMap<>();
        init();
    }

    private void init() {
        for (int i = 0; i <= 15; i++) {
            putEntry("R"+i, i);
        }
        putEntry("SCREEN", 16384);
        putEntry("KBD", 24576);
        //SP, LCL, ARG, THIS and THAT are aliases for R0 .. R4
        putEntry("SP", 0);
        putEntry("LCL", 1);
        putEntry("ARG", 2);
        putEntry("THIS", 3);
        putEntry("THAT", 4);
    }

    public Integer getEntry(String key) {
        return Optional.ofNullable(entries.get(key)).orElseThrow(() -> new ParserException("Symbol not found " + key));
    }

    public void putEntry(String key, Integer value) {
        entries.put(key, value);
    }

    public void build(List<Token> tokens) {
        int address = 0;
        for (Token token : tokens) {
            if (token instanceof Label) {
                putEntry(((Label) token).getLabel(), address);
            } else {
                address++;
            }
        }
        int variable = 16;
        for (Token token : tokens) {
            if (token instanceof Symbol) {
                if (!entries.containsKey(((Symbol) token).getSymbol())) {
                    putEntry(((Symbol) token).getSymbol(), variable);
                    variable++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                "entries=" + entries +
                '}';
    }
}
