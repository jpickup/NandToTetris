package com.hack.computation;

import com.hack.ParserException;

public abstract class Computation {

    public static Computation parse(String s) {
        switch(s) {
            case "0": return new Zero();
            case "1": return new One();
            case "-1": return new MinusOne();
            case "D": return new D();
            case "A": return new A();
            case "!D": return new NotD();
            case "!A": return new NotA();
            case "-D": return new MinusD();
            case "-A": return new MinusA();
            case "D+1": return new DPlusOne();
            case "A+1": return new APlusOne();
            case "D-1": return new DMinusOne();
            case "A-1": return new AMinusOne();
            case "D+A": return new DPlusA();
            case "D-A": return new DMinusA();
            case "A-D": return new AMinusD();
            case "D&A": return new DAndA();
            case "D|A": return new DOrA();
            case "M": return new M();
            case "!M": return new NotM();
            case "-M": return new MinusM();
            case "M+1": return new MPlusOne();
            case "M-1": return new MMinusOne();
            case "D+M": return new DPlusM();
            case "D-M": return new DMinusM();
            case "M-D": return new MMinusD();
            case "D&M": return new DAndM();
            case "D|M": return new DOrM();
            default: throw new ParserException("Unrecognised computation " + s);
        }
    }

    public abstract boolean a();
    public abstract boolean c1();
    public abstract boolean c2();
    public abstract boolean c3();
    public abstract boolean c4();
    public abstract boolean c5();
    public abstract boolean c6();
}
