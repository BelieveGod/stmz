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
 * @date 2020/12/3 14:53
 */
public class LineTest {

    Double min;
    Double max;
    Double A;
    Double B;
    Double C;

    Point[] points;

    @BeforeEach
    public void setUp() throws IOException {
        URL resource = this.getClass().getResource("/mock/mockData2.txt");
        String json = FileUtils.readFileToString(new File(resource.getFile()), "utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        List<List<Double>> lists = objectMapper.readValue(json, new TypeReference<List<List<Double>>>() {
        });
        points=new Point[lists.size()];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }

        for(int i=0;i<lists.size();i++){
            points[i].x=lists.get(i).get(0);
            points[i].y=lists.get(i).get(1);
        }


    }


    @Test
    public void calculate(){

        Point start=points[0];
        Point end = points[points.length - 1];

        A= getA(start, end);
        B=getB(start, end);
        C=getC(start,end);

        min=C;
        max=C;

        for (Point point : points) {
            Double c = getIntercep(point);
            min=Math.min(min,c);
            max=Math.max(max,c);
        }

        Point p1 = getP(start.x, min);
        Point p2 = getP(end.x, min);
        Point p3 = getP(start.x, max);
        Point p4 = getP(end.x, max);

        System.out.println("p1,p2 = [" + p1+","+p2+"]");
        System.out.println("p3,p4 = [" + p3+","+p4+"]");

    }

    public Double getA(Point p1,Point p2){
        return p2.y-p1.y;
    }

    public Double getB(Point p1,Point p2){
        return -(p2.x-p1.x);
    }

    public Double getC(Point p1,Point p2){
        return -(p2.y*p1.x-p1.y*p2.x);
    }

    public Double getIntercep(Point p){
       return -(A*p.x+B*p.y);
    }

    public Point getP(Double x,Double c){
        Double y=-(A/B*x+c/B);
        return new Point(x,y);
    }



}
