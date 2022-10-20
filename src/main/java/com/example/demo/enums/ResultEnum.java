package com.example.demo.enums;

import com.example.demo.result.IResult;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum implements IResult {
    SUCCESS(2001,"OK"),
    FAIL(2002,"Fail"),
    FORBIDDEN(2003,"Non-Auth"),
    NONUSER(2004,"Non-User"),
    INSERTFAIL(2005,"Insert-Fail");

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
