package com.stmz.mgr.test;

import java.util.Scanner;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/3 18:03
 */
public class MathTest {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Double a = sc.nextDouble();
        Double b = sc.nextDouble();
        Double c = sc.nextDouble();
        Double d = sc.nextDouble();
        Double e = sc.nextDouble();
        Double f = sc.nextDouble();
        Double y = (f*a - d*c)/(a*e-d*b);
        Double x = (c-b*y)/a;
        System.out.println(x+" ");
        System.out.println(y);
        sc.close();
    }

}
