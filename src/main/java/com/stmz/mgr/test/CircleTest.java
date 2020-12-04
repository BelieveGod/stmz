package com.stmz.mgr.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:03
 */
public class CircleTest {

    @BeforeEach
    public void setUP() throws IOException {
        URL resource = this.getClass().getResource("/mock/mockData.txt");
        String json = FileUtils.readFileToString(new File(resource.getFile()), "utf-8");
        ObjectMapper mapper = new ObjectMapper();
        List<List<Double>> lists=mapper.readValue(json, new TypeReference<List<List<Double>>>() {
        });

        a=new Point[lists.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Point();
        }

        for(int i=0;i<lists.size();i++){
            a[i].x=lists.get(i).get(0);
            a[i].y=lists.get(i).get(1);
        }
    }

//  半径
    private Double r;
// 圆心
    private Point d=new Point();
    // 圆上一点
    private Point thePoint = new Point();
// 数组
//    private Point[] a=new Point[]{new Point(0d,0d),new Point(0d,2d),new Point(1d,1d)};
    private Point[] a;
//     两点距离
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
        // 记录圆上的一点
        thePoint.x=p.x;thePoint.y=p.y;

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
                // 记录圆上的一点
                thePoint.x=a[k].x;thePoint.y=a[k].y;
            }
            else{
                t1=distance(p,q);
                t2=distance(q,a[k]);
                t3=distance(p,a[k]);
                if(t1>=t2&&t1>=t3){
                    d.x=(p.x+q.x)/2.0;d.y=(p.y+q.y)/2.0;r=distance(p,q)/2.0;
                    // 记录圆上的一点
                    thePoint.x=p.x;thePoint.y=p.y;
                }
                else if(t2>=t1&&t2>=t3){
                    d.x=(a[k].x+q.x)/2.0;d.y=(a[k].y+q.y)/2.0;r=distance(a[k],q)/2.0;
                    // 记录圆上的一点
                    thePoint.x=q.x;thePoint.y=q.y;
                }
                else{
                    d.x=(a[k].x+p.x)/2.0;d.y=(a[k].y+p.y)/2.0;r=distance(a[k],p)/2.0;
                    // 记录圆上的一点
                    thePoint.x=p.x;thePoint.y=p.y;
                }
            }
        }
    }

    void MiniDiscWithPoint(Point   pi,int   n){
        d.x=(pi.x+a[0].x)/2.0;
        d.y=(pi.y+a[0].y)/2.0;
        r=distance(pi,a[0])/2.0;
        // 记录圆上的一点
        thePoint.x=a[0].x;thePoint.y=a[0].y;

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
        // 记录圆上的一点
        thePoint.x=a[0].x;thePoint.y=a[0].y;

        d.x=(a[0].x+a[1].x)/2.0;
        d.y=(a[0].y+a[1].y)/2.0;
        for(int i=2;i<n;i++){
            if(distance(d,a[i])<=r)continue;
            else{
                MiniDiscWithPoint(a[i],i-1);
            }
        }
        System.out.println("["+d.x+","+d.y+"] R="+r);
        Double distance = distance(d, thePoint);
        System.out.println("圆上一点:"+thePoint.toString()+" distance:"+distance);

        double getmeter = LocationUtils.getmeter(d.x, d.y, thePoint.x, thePoint.y);
        System.out.println("圆上的范围误差：" + getmeter+"米");
    }


}
