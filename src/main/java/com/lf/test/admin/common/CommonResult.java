package com.lf.test.admin.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Getter
@Setter
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){}

    protected CommonResult(long code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    /**
     * 返回成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 返回成功结果，自定义信息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    /**
     * 返回失败结果，自定义信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 未授权返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbbiden(){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    /**
     * 未授权返回结果,自定义信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbbiden(String message){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),message,null);
    }


}
