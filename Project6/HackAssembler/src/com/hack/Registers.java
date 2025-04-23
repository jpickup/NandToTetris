package com.hack;

import java.util.HashSet;
import java.util.Set;

public class Registers {
    public Registers(Set<Register> registers) {
        this.registers = registers;
    }

    public static Registers parse(String s) {
        Set<Register> result = new HashSet<>();
        while (!s.isEmpty()) {
            result.add(Register.valueOf(s.substring(0, 1)));
            s = s.substring(1);
        }
        return new Registers(result);
    }

    public Set<Register> getRegisters() {
        return registers;
    }

    private final Set<Register> registers;

    public boolean d1() {
        return registers.stream().map(Register::isD1).reduce(false, (a,b) -> a | b);
    }

    public boolean d2() {
        return registers.stream().map(Register::isD2).reduce(false, (a,b) -> a | b);
    }

    public boolean d3() {
        return registers.stream().map(Register::isD3).reduce(false, (a,b) -> a | b);
    }

    @Override
    public String toString() {
        return "Registers{" +
                "registers=" + registers +
                '}';
    }
}
