package com.hugh.mallonline.product.exception;

/**
 * Created by hugh on 2021/3/3
 *
 * 集中处理所有异常
 */

import com.hugh.common.utils.R;
import com.hugh.common.exception.BizCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class MallExceptionAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        Map<String, String> errorMap = new HashMap<>();
        log.error("数据校验出现异常：{}，异常类型：{}", e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();
        result.getFieldErrors().forEach((item)->{
            errorMap.put(item.getField(),item.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(),BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data",errorMap);
    }

}
