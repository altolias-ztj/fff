package com.woniuxy.canteen.vo;

import lombok.Data;


@Data
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T data;

    public static ResponseResult<Void> ok() {
        ResponseResult<Void> responseResult = new ResponseResult<>();
        responseResult.setCode(200);
        responseResult.setMsg("ok");
        return responseResult;
    }

    public static <T> ResponseResult<T> ok(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(200);
        responseResult.setMsg("ok");
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult<Void> loginFail() {
        ResponseResult<Void> responseResult = new ResponseResult<>();
        responseResult.setCode(5);
        responseResult.setMsg("login fail!");
        return responseResult;
    }

    public static <T> ResponseResult<T> fail() {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(500);
        responseResult.setMsg("fail");
        return responseResult;
    }
}
