package com.example.demo.result;

import com.example.demo.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static Result<?> success(){
        return new Result<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),null);
    }
    public static <T> Result<T> success(T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }
    public static Result<?> fail(ResultEnum result){
        return new Result<>(result.getCode(),result.getMsg(),null);
    }
    public static <T> Result<T> fail(ResultEnum result,T data){
        return new Result<>(result.getCode(),result.getMsg(),data);
    }
    public static <T> Result<T> instance(Integer code,String msg,T data){
        return new Result<T>(code,msg,data);
    }
}
