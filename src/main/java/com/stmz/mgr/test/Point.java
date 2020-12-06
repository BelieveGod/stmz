package com.stmz.mgr.test;

import lombok.Data;

import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:34
 */
public class Point {
    public Double x;
    public Double y;

    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public Point(List<Double> coordinate){
        x=coordinate.get(0);
        y=coordinate.get(1);
    }

    public static Double getDistance(Point p1,Point p2){
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static Point getMiddlePoint(Point p1,Point p2){
        return new Point((p1.x+p2.x)/2.0,(p1.y+p2.y)/2.0);
    }
}
