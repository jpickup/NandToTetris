package com.hack.token;

import com.hack.HackInstruction;
import com.hack.Registers;
import com.hack.SymbolTable;
import com.hack.computation.Computation;

import java.util.regex.Matcher;

public class Assignment extends Token {
    private final Registers to;
    private final Computation computation;
    public Assignment(Matcher matcher) {
        String registersGroup = matcher.group(1);
        String computationGroup = matcher.group(2);
        to = Registers.parse(registersGroup);
        computation = Computation.parse(computationGroup);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "to=" + to +
                ", computation=" + computation +
                '}';
    }

    @Override
    public HackInstruction toHackInstruction(SymbolTable symbolTable) {
        HackInstruction result = new HackInstruction();
        result.aOrCInstruction(true);
        result.a(computation.a());
        result.c1(computation.c1());
        result.c2(computation.c2());
        result.c3(computation.c3());
        result.c4(computation.c4());
        result.c5(computation.c5());
        result.c6(computation.c6());
        result.d1(to.d1());
        result.d2(to.d2());
        result.d3(to.d3());
        return result;
    }
}
