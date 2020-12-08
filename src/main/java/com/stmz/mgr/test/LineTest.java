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

import static com.stmz.mgr.test.Line.getLine;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 14:53
 */
public class LineTest {

    Line minLine;
    Line maxLine;
    Line offsetLine=new Line();

    Point[] points;

    @BeforeEach
    public void setUp() throws IOException {
        URL resource = this.getClass().getResource("/mock/mockData3.txt");
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

        offsetLine=getLine(start,end);

        minLine=offsetLine;
        maxLine=offsetLine;

        for (Point point : points) {
            Line line = getLine(offsetLine.A, offsetLine.B, point);
            minLine=chooseMinLine(minLine,line);
            maxLine=chooseMaxLine(maxLine,line);
        }


        Line verticalLine1= getLine(offsetLine.B,-offsetLine.A,start);
        Line verticalLine2 = getLine(offsetLine.B, -offsetLine.A, end);

        Point p1 = getCrossPoint(maxLine, verticalLine1);
        Point p2 =  getCrossPoint(maxLine,verticalLine2);

        Point p3 = getCrossPoint(minLine,verticalLine1);
        Point p4 = getCrossPoint(minLine,verticalLine2);


        System.out.println("p1,p2 = [" + p1+","+p2+"]");
        System.out.println("p3,p4 = [" + p3+","+p4+"]");

        double startDis = LocationUtils.getmeter(start.x, start.y, p1.x, p1.y);
        double startDis2 = LocationUtils.getmeter(start.x, start.y, p3.x, p3.y);
        System.out.println("startDis = " + startDis+"米");
        System.out.println("startDis2 = " + startDis2+"米");

        double endDis = LocationUtils.getmeter(end.x, end.y, p2.x, p2.y);
        double endDis2 = LocationUtils.getmeter(end.x, end.y, p4.x, p4.y);
        System.out.println("end = " + endDis+"米");
        System.out.println("end = " + endDis2+"米");
    }






    public Line chooseMinLine(Line l1,Line l2){
        return l1.C>l2.C?l2:l1;
    }

    public Line chooseMaxLine(Line l1,Line l2){
        return l1.C<l2.C?l2:l1;
    }



    /**
     * 解方程组，求出交点,矩阵消元法
     */
    public Point getCrossPoint(Double a1,Double b1,Double c1,Double a2,Double b2,Double c2){
        c1=-c1;
        c2=-c2;

        Double y = (c1*a2 - c2*a1)/(b1*a2-b2*a1);
        Double x = (c1-b1*y)/a1;
        return new Point(x,y);
    }

    /**
     * 解方程组，求出交点
     */
    public Point getCrossPoint(Line l1,Line l2){
        return getCrossPoint(l1.A, l1.B, l1.C, l2.A, l2.B, l2.C);
    }



}
