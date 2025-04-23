package com.hack.token;

import com.hack.HackInstruction;
import com.hack.SymbolTable;

import java.util.Objects;

public class Symbol extends Token {
    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return Objects.equals(symbol, symbol1.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }

    @Override
    public String toString() {
        return "com.hack.token.Symbol{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    @Override
    public HackInstruction toHackInstruction(SymbolTable symbolTable) {
        HackInstruction hackInstruction = new HackInstruction();
        hackInstruction.setLiteral(symbolTable.getEntry(symbol));
        return hackInstruction;
    }
}
