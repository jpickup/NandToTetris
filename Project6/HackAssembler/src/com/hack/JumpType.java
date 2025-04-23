package com.hack;

public enum JumpType {
    JMP(true, true, true),
    JGT(false, false, true),
    JEQ(false, true, false),
    JLT(true, false, false),
    JGE(false, true, true),
    JLE(true, true, false),
    JNE(true, false, true),
    NULL(false, false, false) ;

    JumpType(boolean j1, boolean j2, boolean j3) {
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
    }

    public boolean j1() {
        return j1;
    }

    public boolean j2() {
        return j2;
    }

    public boolean j3() {
        return j3;
    }

    private final boolean j1;
    private final boolean j2;
    private final boolean j3;
}
