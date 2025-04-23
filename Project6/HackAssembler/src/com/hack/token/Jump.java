package com.hack.token;

import com.hack.HackInstruction;
import com.hack.JumpType;
import com.hack.SymbolTable;
import com.hack.computation.Computation;

import java.util.regex.Matcher;

public class Jump extends Token {
    private final Computation computation;
    private final JumpType jumpType;

    public Jump(Matcher matcher) {
        String computationGroup = matcher.group(1);
        String jumpGroup = matcher.group(2);

        computation = Computation.parse(computationGroup);
        jumpType = JumpType.valueOf(jumpGroup);
    }

    @Override
    public String toString() {
        return "Jump{" +
                "computation=" + computation +
                ", jumpType=" + jumpType +
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
        result.j1(jumpType.j1());;
        result.j2(jumpType.j2());
        result.j3(jumpType.j3());
        return result;
    }
}
