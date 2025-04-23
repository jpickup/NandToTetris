package com.hack;

public class HackInstruction {
    private final boolean[] bits = new boolean[16];

    public void aOrCInstruction(boolean value) {
        bits[15] = value;
        if (value) {
            bits[13] = true;
            bits[14] = true;
        }
    }

    private void setBit(int index, boolean value) {
        bits[index] = value;
    }

    public void a(boolean value) {
        bits[12] = value;
    }

    public void c1(boolean value) {
        bits[11] = value;
    }
    public void c2(boolean value) {
        bits[10] = value;
    }
    public void c3(boolean value) {
        bits[9] = value;
    }
    public void c4(boolean value) {
        bits[8] = value;
    }
    public void c5(boolean value) {
        bits[7] = value;
    }
    public void c6(boolean value) {
        bits[6] = value;
    }
    public void d1(boolean value) {
        bits[5] = value;
    }
    public void d2(boolean value) {
        bits[4] = value;
    }
    public void d3(boolean value) {
        bits[3] = value;
    }
    public void j1(boolean value) {
        bits[2] = value;
    }
    public void j2(boolean value) {
        bits[1] = value;
    }
    public void j3(boolean value) {
        bits[0] = value;
    }

    public String asBinaryText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 15; i >= 0; i--) {
            sb.append(bits[i] ? '1' : '0');
        }
        return sb.toString();
    }

    public void setLiteral(int value) {
        aOrCInstruction(false);
        setBit(0, (value & 0x1) == 0x1);
        setBit(1, (value & 0x2) == 0x2);
        setBit(2, (value & 0x4) == 0x4);
        setBit(3, (value & 0x8) == 0x8);
        setBit(4, (value & 0x10) == 0x10);
        setBit(5, (value & 0x20) == 0x20);
        setBit(6, (value & 0x40) == 0x40);
        setBit(7, (value & 0x80) == 0x80);
        setBit(8, (value & 0x100) == 0x100);
        setBit(9, (value & 0x200) == 0x200);
        setBit(10, (value & 0x400) == 0x400);
        setBit(11, (value & 0x800) == 0x800);
        setBit(12, (value & 0x1000) == 0x1000);
        setBit(13, (value & 0x2000) == 0x2000);
        setBit(14, (value & 0x4000) == 0x4000);
    }
}
