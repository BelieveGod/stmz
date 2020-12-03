package com.stmz.mgr.test;

import org.junit.jupiter.api.Test;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:03
 */
public class CircleTest {

//  半径
    private Double r;
// 圆心
    private Point d=new Point();
// 数组
//    private Point[] a=new Point[]{new Point(0d,0d),new Point(0d,2d),new Point(1d,1d),new Point(1.7d,1.4d)};
    private Point[] a=new Point[]{new Point(0d,0d),new Point(0d,4d),new Point(8d,4d)};
    // 两点距离
    private Double distance(Point p1,Point p2){
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    private Double sqr(Double x){
        return x*x;
    }





    Double multiply(Point p1,Point p2,Point p0){
        return   ((p1.x-p0.x)*(p2.y-p0.y)-(p2.x-p0.x)*(p1.y-p0.y));
    }

    void MiniDiscWith2Point(Point   p,Point   q,int   n){
        d.x=(p.x+q.x)/2.0;
        d.y=(p.y+q.y)/2.0;
        r=distance(p,q)/2;
        int k;
        double c1,c2,t1,t2,t3;
        for(k=0;k<n;k++){
            if(distance(d,a[k])<=r)continue;
            if(multiply(p,q,a[k])!=0.0){
                c1=(p.x*p.x+p.y*p.y-q.x*q.x-q.y*q.y)/2.0;
                c2=(p.x*p.x+p.y*p.y-a[k].x*a[k].x-a[k].y*a[k].y)/2.0;
                d.x=(c1*(p.y-a[k].y)-c2*(p.y-q.y))/((p.x-q.x)*(p.y-a[k].y)-(p.x-a[k].x)*(p.y-q.y));
                d.y=(c1*(p.x-a[k].x)-c2*(p.x-q.x))/((p.y-q.y)*(p.x-a[k].x)-(p.y-a[k].y)*(p.x-q.x));
                r=distance(d,a[k]);
            }
            else{
                t1=distance(p,q);
                t2=distance(q,a[k]);
                t3=distance(p,a[k]);
                if(t1>=t2&&t1>=t3){
                    d.x=(p.x+q.x)/2.0;d.y=(p.y+q.y)/2.0;r=distance(p,q)/2.0;
                }
                else if(t2>=t1&&t2>=t3){
                    d.x=(a[k].x+q.x)/2.0;d.y=(a[k].y+q.y)/2.0;r=distance(a[k],q)/2.0;
                }
                else{
                    d.x=(a[k].x+p.x)/2.0;d.y=(a[k].y+p.y)/2.0;r=distance(a[k],p)/2.0;
                }
            }
        }
    }

    void MiniDiscWithPoint(Point   pi,int   n){
        d.x=(pi.x+a[0].x)/2.0;
        d.y=(pi.y+a[0].y)/2.0;
        r=distance(pi,a[0])/2.0;
        int j;
        for(j=1;j<n;j++){
            if(distance(d,a[j])<=r)continue;
            else{
                MiniDiscWith2Point(pi,a[j],j-1);
            }
        }
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
        int n=a.length;
        r=distance(a[0],a[1])/2.0;
        d.x=(a[0].x+a[1].x)/2.0;
        d.y=(a[0].y+a[1].y)/2.0;
        for(int i=2;i<n;i++){
            if(distance(d,a[i])<=r)continue;
            else{
                MiniDiscWithPoint(a[i],i-1);
            }
        }
        System.out.println(d.x+","+d.y+" R="+r);
    }


}
