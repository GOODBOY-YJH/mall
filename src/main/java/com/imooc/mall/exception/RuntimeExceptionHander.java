package com.imooc.mall.exception;

import com.imooc.mall.enums.ResponseEnum;
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

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public  ResponseVo userLoginHandle(){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
    // @ExceptionHandler(IllegalArgumentException.class)
    // @ResponseBody
    // public  ResponseVo notValidException(IllegalArgumentException e){
    //     BindingResult bindingResult = e.get();
    //     return ResponseVo.error(ResponseEnum.PARAM_ERROR,
    //             Objects.requireNonNull(bindingResult.getFieldError()).getField() + " "
    //                     + bindingResult.getFieldError().getDefaultMessage());
    // }
}
