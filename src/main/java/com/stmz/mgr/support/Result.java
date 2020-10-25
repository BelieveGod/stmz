package com.stmz.mgr.support;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 13:24
 * @Version 1.0
 */
public class Result implements Serializable {
    private Integer code;

    private String msg;

    private Integer count;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {

    }

    public Result(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static Result ok(){
        return new Result(200,"operation success",0,null);
    }

    public static Result fail(){
        return new Result(400,"operation fail",0,null);
    }
}
