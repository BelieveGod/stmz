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

    public static Line getLine(Double a,Double b, Point p){
        Line line =new Line();
        line.A=a;
        line.B=b;
        line.C=-(a*p.x+b*p.y);
        return line;
    }

    public static Line getLine(Point p1,Point p2){
        Line line = new Line();
        line.A =p2.y-p1.y;
        line.B=-(p2.x-p1.x);
        line.C=-(p2.y*p1.x-p1.y*p2.x);
        return line;
    }
}
