package com.stmz.mgr.test;

import com.stmz.mgr.support.HCNetSDK;
import com.stmz.mgr.support.HCNetSDK.NET_DVR_JPEGPARA;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/11 10:46
 */
public class HCTest {

    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    private static String deviceIp="10.7.5.151";
    private static short port=8000;
    private static String userName="admin";
    private static String password="haikang12345";


    public static void main(String[] args) {
        HCNetSDK.NET_DVR_USER_LOGIN_INFO m_strLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();//设备登录信息
        HCNetSDK.NET_DVR_DEVICEINFO_V40 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();//设备信息

        // 登录信息
        m_strLoginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(deviceIp.getBytes(), 0, m_strLoginInfo.sDeviceAddress, 0, deviceIp.length());

        m_strLoginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(userName.getBytes(), 0, m_strLoginInfo.sUserName, 0, userName.length());

        m_strLoginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(password.getBytes(), 0, m_strLoginInfo.sPassword, 0, password.length());

        m_strLoginInfo.wPort = port;

        m_strLoginInfo.bUseAsynLogin = false; //是否异步登录：0- 否，1- 是


        // ===============================================

        boolean initSuc = hCNetSDK.NET_DVR_Init();
        if (!initSuc){
            System.out.println("初始化失败");
        }
        int userID = hCNetSDK.NET_DVR_Login_V40(m_strLoginInfo, m_strDeviceInfo);

        if(userID>-1){
            System.out.println("登陆成功,账户id："+userID);

            int instruct=0;
            int iChanel=1;
            Scanner scanner = new Scanner(System.in);
            // 接受命令行指令
            while(instruct!=9){
                 instruct = scanner.nextInt();
                switch (instruct) {
                case 1:
                    hCNetSDK.NET_DVR_PTZControl_Other(userID, iChanel, HCNetSDK.PAN_LEFT, 0);
                    break;
                case 2:
                    hCNetSDK.NET_DVR_PTZControl_Other(userID, iChanel, HCNetSDK.PAN_LEFT, 1);
                    NET_DVR_JPEGPARA lpJpegPara = new NET_DVR_JPEGPARA();
                    lpJpegPara.wPicSize=6;
                    lpJpegPara.wPicQuality=0;
                    String file = "D:\\picture" + File.separator+LocalDate.now().toString() + "_tj.jpg";

                    hCNetSDK.NET_DVR_CaptureJPEGPicture(userID, iChanel, lpJpegPara, file);
                    break;
                case 3:
                    hCNetSDK.NET_DVR_PTZControl_Other(userID, iChanel, HCNetSDK.PAN_RIGHT, 0);
                    break;
                case 4:
                    hCNetSDK.NET_DVR_PTZControl_Other(userID, iChanel, HCNetSDK.PAN_RIGHT, 1);
                    break;
                }
            }
            logout(userID);
        }
        else{
            System.out.println("登陆失败,错误号："+hCNetSDK.NET_DVR_GetLastError());
        }

        // 释放sdk资源
        hCNetSDK.NET_DVR_Cleanup();
        System.out.println("释放资源");



    }

    public static void logout(int userId){
        boolean isLogout = hCNetSDK.NET_DVR_Logout_V30(userId);

        if(isLogout){
            System.out.println("注销成功");
        }
        else{
            System.out.println("注销失败");
        }
    }
}
