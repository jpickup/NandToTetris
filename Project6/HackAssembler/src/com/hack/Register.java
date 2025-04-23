package com.hack;

public enum Register {
    A(true, false, false),
    D(false, true, false),
    M(false, false, true);

    public boolean isD1() {
        return d1;
    }

    public boolean isD2() {
        return d2;
    }

    public boolean isD3() {
        return d3;
    }

    private final boolean d1;
    private final boolean d2;
    private final boolean d3;

    Register(boolean d1, boolean d2, boolean d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
}
