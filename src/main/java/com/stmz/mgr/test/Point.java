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
}
