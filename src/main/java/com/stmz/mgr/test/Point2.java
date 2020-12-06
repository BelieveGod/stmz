package com.stmz.mgr.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:34
 */
public class Point2 {
    private static MathContext mc=new MathContext(12,RoundingMode.HALF_UP);
    public BigDecimal x;
    public BigDecimal y;

    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }

    public Point2(Double x, Double y) {
        this.x = new BigDecimal(x,mc);
        this.y = new BigDecimal(y,mc);
    }

    public Point2() {
    }

    public Point2(List<Double> coordinate){
        this(coordinate.get(0),coordinate.get(1));
    }

    public static BigDecimal getDistance(Point2 p1, Point2 p2){
        mc = new MathContext(12, RoundingMode.HALF_UP);
        return p2.x.subtract(p1.x).pow(2).add(p2.y.subtract(p1.y).pow(2)).sqrt(mc);
    }

    public static Point2 getMiddlePoint(Point2 p1, Point2 p2){
        return new Point2(p1.x.add(p2.x).divide(new BigDecimal("2"),mc).doubleValue(),p1.y.add(p2.y).divide(new BigDecimal("2"),mc).doubleValue());
    }
}
