package com.stmz.mgr.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Line2 {
    public BigDecimal A;
    public BigDecimal B;
    public BigDecimal C;
    private static MathContext mc=new MathContext(12, RoundingMode.HALF_UP);

    @Override
    public String toString() {
        return A.toPlainString()+"x"+B.toPlainString()+"y"+C.toPlainString()+"=0";
    }

    public Line2() {
    }

    public Line2(Double a, Double b, Double c) {

        A = new BigDecimal(a,mc);
        B = new BigDecimal(b,mc);
        C = new BigDecimal(c,mc);
    }

    public static Line2 getLine(Double a, Double b, Point2 p){
        Line2 line =new Line2();
        line.A=new BigDecimal(a,mc);
        line.B=new BigDecimal(b,mc);
        line.C = line.A.multiply(p.x).add(line.B.multiply(p.y)).negate();
        return line;
    }

    public static Line2 getLine(Point2 p1, Point2 p2){
        Line2 line = new Line2();
        line.A=p2.y.subtract(p1.y);
        line.B=p2.x.subtract(p1.x);
        line.C=p2.y.multiply(p1.x).subtract(p1.y.multiply(p2.x)).negate();
        return line;
    }



    /**
     * 求两点的垂直平分线方程
     * @param p1
     * @param p2
     * @return
     */
    public static Line2 getVerticalMiddleLine(Point2 p1, Point2 p2){
        Line2 line1 = Line2.getLine(p1, p2);
        Point2 middlePoint1 = Point2.getMiddlePoint(p1, p2);
       return Line2.getLine(line1.B.doubleValue(),line1.A.negate().doubleValue(),middlePoint1);
    }

    /**
     * 解方程组，求出交点,矩阵消元法
     */
    public static Point2 getCrossPoint(BigDecimal a1,BigDecimal b1,BigDecimal c1,BigDecimal a2,BigDecimal b2,BigDecimal c2){
        c1=c1.negate();
        c2=c2.negate();

        BigDecimal y = c1.multiply(a2).subtract(c2.multiply(a1)).divide(b1.multiply(a2).subtract(b2.multiply(a1)),mc);
        BigDecimal x = c1.subtract(b1.multiply(y)).divide(a1,mc);

        return new Point2(x.doubleValue(),y.doubleValue());

    }

    /**
     * 解方程组，求出交点
     */
    public static Point2 getCrossPoint(Line2 l1, Line2 l2){
        return getCrossPoint(l1.A, l1.B, l1.C, l2.A, l2.B, l2.C);
    }


}
