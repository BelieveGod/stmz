package com.stmz.mgr.test;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;

public class GeoTest {

    public static void main(String[] args){

        GlobalCoordinates source = new GlobalCoordinates(22.967009501247585, 113.90961289401884);
        GlobalCoordinates target = new GlobalCoordinates(22.96700766706298, 113.90961239418735);
        double meter1 = getDistanceMeter(source, target, Ellipsoid.Sphere);
        double meter2 = getDistanceMeter(source, target, Ellipsoid.WGS84);
        double meter3 = LocationUtils.getmeter(113.90961289401884, 22.967009501247585, 113.90961239418735, 22.96700766706298);
        double meter4 = LocationUtils2.distance(113.90961289401884, 22.967009501247585, 113.90961239418735, 22.96700766706298);

        System.out.println("Sphere坐标系计算结果："+meter1 + "米");
        System.out.println("WGS84坐标系计算结果："+meter2 + "米");
        System.out.println("自定义计算结果："+meter3 + "米");
        System.out.println("自定义2计算结果："+meter4 + "米");
    }

    public static double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid){

        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);

        return geoCurve.getEllipsoidalDistance();
    }
}
