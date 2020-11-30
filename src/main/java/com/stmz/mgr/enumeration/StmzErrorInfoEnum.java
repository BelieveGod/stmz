package com.stmz.mgr.enumeration;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/11/30 15:33
 */
public enum StmzErrorInfoEnum implements StmzErrorInfo{
    SUCCESS(200,"请求成功"),
    FAILD(400,"请求失败"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");


    StmzErrorInfoEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 错误码
     */
    private Integer resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;


    @Override
    public Integer getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
