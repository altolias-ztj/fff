package com.woniuxy.canteen.exception;

import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.woniuxy.canteen.web")
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseResult<Map<String, String>> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errors = e.getFieldErrors();
        for (FieldError error : errors) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errorMap.put(field, message);
        }
        ResponseResult<Map<String, String>> responseResult = new ResponseResult<>();
        responseResult.setCode(405);
        responseResult.setMsg("参数错误.");
        responseResult.setData(errorMap);
        return responseResult;
    }

    @ExceptionHandler
    public ResponseResult<Void> handleException(Exception e) {
        e.printStackTrace();
        if (e instanceof DataAccessException) {

        } else {

        }
        return ResponseResult.fail();
    }
}
