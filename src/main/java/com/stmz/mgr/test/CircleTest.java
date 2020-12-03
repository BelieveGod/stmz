package com.stmz.mgr.test;

import org.junit.jupiter.api.Test;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:03
 */
public class CircleTest {

//  半径
    private Double R;
// 圆心
    private Point O;

    private Point[] points=new Point[]{new Point(0d,0d),new Point(0d,2d),new Point(1d,1d)};
    // 两点距离
    private Double distance(Point a,Point b){
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    private Double sqr(Double x){
        return x*x;
    }

    private Double step(Point a,Point b){
       return  (sqr(b.x)+sqr(b.y)-sqr(a.x)-sqr(a.y))/2;
    }

    boolean inCircle(Point a){
        if(distance(a,O).compareTo(R)<=0){
            return true;
        }
        return false;
    }

    private Point solve(Double a,Double b,Double c,Double d,Double e,Double f){
        Double y=(f*a-c*d)/(b*d-e*a);
        Double x=(f*b-c*e)/(a*e-b*d);
        return new Point(x,y);
    }

    @Test
    public void test(){
        Double a=8d;
        Double b=6d;
        int i = a.compareTo(b);
        System.out.println("i = " + i);
    }

    @Test
    public void test2(){
        int n=points.length;
        R=0d;
        O=points[0];
        for(int i=1;i<n;i++){
            if(!inCircle(points[i])){
                O.x=points[i].x;
                O.y=points[i].y;
                R=0d;
                for(int j=0;j<i;j++){
                    if(!inCircle(points[j])){
                        O.x=(points[i].x+points[j].x)/2;
                        O.y=(points[i].y+points[j].y)/2;
                        R = distance(O, points[i]);
                        for(int k=0;k<j;k++){
                            if(!inCircle(points[k])){
                                O=solve(points[i].x-points[j].x,points[i].y-points[j].y,step(points[i],points[j]),
                                        points[i].x-points[k].x,points[i].y-points[k].y,step(points[i],points[k])
                                );
                                R=distance(points[i],O);
                            }
                        }

                    }
                }
            }
        }
        System.out.println("("+O.x+","+O.y+")");
        System.out.println("R = " + R);
    }


}
