package com.stmz.mgr.test;

public class Line {
    public Double A;
    public Double B;
    public Double C;

    @Override
    public String toString() {
        return A+"x"+B+"y"+C+"=0";
    }

    public Line() {
    }

    public Line(Double a, Double b, Double c) {
        A = a;
        B = b;
        C = c;
    }
}
