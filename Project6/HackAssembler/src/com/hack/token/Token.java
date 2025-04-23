package com.hack.token;

import com.hack.HackInstruction;
import com.hack.SymbolTable;

public abstract class Token {
    public abstract HackInstruction toHackInstruction(SymbolTable symbolTable);
}
