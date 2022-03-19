package com.imooc.mall.exception;

import com.imooc.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.imooc.mall.enums.ResponseEnum.ERROR;

@ControllerAdvice
public class RuntimeExceptionHander {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    // @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ERROR, e.getMessage());
    }

}
