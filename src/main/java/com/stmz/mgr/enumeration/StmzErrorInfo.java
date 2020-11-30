package com.stmz.mgr.enumeration;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/11/30 15:32
 */
public interface StmzErrorInfo {
    /**
     * 错误码
     * @return
     */
    Integer getResultCode();


    /**
     * 错误信息
     */

    String getResultMsg();
}
