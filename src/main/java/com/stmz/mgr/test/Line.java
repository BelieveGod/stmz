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

    public static boolean isParallel(Line l1,Line l2){
        return (l1.A*l2.B-l2.A*l1.B < Double.MIN_VALUE) && (l1.C-l2.C> Double.MIN_VALUE);
    }

    public static boolean isOneLine(Line l1,Line l2){
        return (l1.A*l2.B-l2.A*l1.B < Double.MIN_VALUE) && (l1.C-l2.C< Double.MIN_VALUE);
    }

    /**
     * 求两点的垂直平分线方程
     * @param p1
     * @param p2
     * @return
     */
    public static Line getVerticalMiddleLine(Point p1,Point p2){
        Line line1 = Line.getLine(p1, p2);
        Point middlePoint1 = Point.getMiddlePoint(p1, p2);
       return Line.getLine(line1.B,-line1.A,middlePoint1);
    }

    /**
     * 解方程组，求出交点,矩阵消元法
     */
    public static Point getCrossPoint(Double a1,Double b1,Double c1,Double a2,Double b2,Double c2){
        c1=-c1;
        c2=-c2;

        Double y = (c1*a2 - c2*a1)/(b1*a2-b2*a1);
        Double x = (c1-b1*y)/a1;
        return new Point(x,y);
    }

    /**
     * 解方程组，求出交点
     */
    public static Point getCrossPoint(Line l1,Line l2){
        return getCrossPoint(l1.A, l1.B, l1.C, l2.A, l2.B, l2.C);
    }


}
