package com.stmz.mgr.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:03
 */
public class CircleTest2 {

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






    Double multiply(Point p1,Point p2,Point p0){
        return   ((p1.x-p0.x)*(p2.y-p0.y)-(p2.x-p0.x)*(p1.y-p0.y));
    }

    @Test
    public void calculate(){
        if(a.length<1){
            throw new IllegalArgumentException("必须大于1个元素");
        }

        // 初始值
        d=a[0];
        r=0d;

        for(int i=1;i<a.length;i++){
            if(Point.getDistance(d,a[i])<=r){
                continue;
            }
            else{
                miniCircle(a[i], i);
            }
        }

        System.out.println("d = " + d);
        System.out.println("r = " + r);
    }

    /**
     * 找到过P点包含前J个点的最小圆
     * @param p1
     * @param i
     */
    public void miniCircle(Point p1,int i){
        d=Point.getMiddlePoint(p1,a[0]);
        r = Point.getDistance(d, p1);
        for(int j=1;j<i;j++){
            if(Point.getDistance(d,a[j])<=r){
                continue;
            }
            else{
                miniCircle(p1, a[j], j);
            }
        }
    }

    /**
     * 找到过P1 , p2 两点，包含前k个点的最小圆
     */

    public void miniCircle(Point p1,Point p2,int j){
        d=Point.getMiddlePoint(p1,p2);
        r = Point.getDistance(d, p1);
       for(int k=0;k<j;k++){
           if(Point.getDistance(d,a[k])<=r){
               continue;
           }
           else{
               Line verticalMiddleLine1 = Line.getVerticalMiddleLine(p1, p2);
               Line verticalMiddleLine2 = Line.getVerticalMiddleLine(p1, a[k]);
               // 圆心等于垂直平分线交点
               d= Line.getCrossPoint(verticalMiddleLine1, verticalMiddleLine2);

               Double r1=Point.getDistance(d,p1);
               Double r2=Point.getDistance(d,p2);
               Double r3=Point.getDistance(d,a[k]);
               r=r1;
               System.out.println("r1 = " + r1);
               System.out.println("r2 = " + r2);
               System.out.println("r3 = " + r3);

           }
       }
    }


}
