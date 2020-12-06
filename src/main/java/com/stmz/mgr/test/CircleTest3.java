package com.stmz.mgr.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 10:03
 */
public class CircleTest3 {

    @BeforeEach
    public void setUP() throws IOException {
        URL resource = this.getClass().getResource("/mock/mockData.txt");
        String json = FileUtils.readFileToString(new File(resource.getFile()), "utf-8");
        ObjectMapper mapper = new ObjectMapper();
        List<List<Double>> lists=mapper.readValue(json, new TypeReference<List<List<Double>>>() {
        });

        a=new Point2[lists.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Point2();
        }

        for(int i=0;i<lists.size();i++){
            a[i].x=new BigDecimal(lists.get(i).get(0).toString());
            a[i].y=new BigDecimal(lists.get(i).get(1).toString());
        }
    }

//  半径
    private BigDecimal r;
// 圆心
    private Point2 d=new Point2();
    // 圆上一点
    private Point2 thePoint = new Point2();
// 数组
//    private Point[] a=new Point[]{new Point(0d,0d),new Point(0d,2d),new Point(1d,1d)};
    private Point2[] a;








    @Test
    public void calculate(){
        if(a.length<1){
            throw new IllegalArgumentException("必须大于1个元素");
        }

        // 初始值
        d=a[0];
        r=new BigDecimal("0");

        for(int i=1;i<a.length;i++){
            if(Point2.getDistance(d,a[i]).compareTo(r)<=0){
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
    public void miniCircle(Point2 p1,int i){
        d=Point2.getMiddlePoint(p1,a[0]);
        r = Point2.getDistance(d, p1);
        for(int j=1;j<i;j++){
            if(Point2.getDistance(d,a[j]).compareTo(r)<=0){
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

    public void miniCircle(Point2 p1,Point2 p2,int j){
        d=Point2.getMiddlePoint(p1,p2);
        r = Point2.getDistance(d, p1);
       for(int k=0;k<j;k++){
           if(Point2.getDistance(d,a[k]).compareTo(r)<=0){
               continue;
           }
           else{
               Line2 verticalMiddleLine1 = Line2.getVerticalMiddleLine(p1, p2);
               Line2 verticalMiddleLine2 = Line2.getVerticalMiddleLine(p1, a[k]);
               // 圆心等于垂直平分线交点
               d= Line2.getCrossPoint(verticalMiddleLine1, verticalMiddleLine2);

               BigDecimal r1=Point2.getDistance(d,p1);
               BigDecimal r2=Point2.getDistance(d,p2);
               BigDecimal r3=Point2.getDistance(d,a[k]);
               r=r1;
               System.out.println("r1 = " + r1.doubleValue());
               System.out.println("r2 = " + r2.doubleValue());
               System.out.println("r3 = " + r3.doubleValue());

           }
       }
    }


}
