package com.lf.test.admin.common;

import lombok.Data;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public enum  ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;


    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
