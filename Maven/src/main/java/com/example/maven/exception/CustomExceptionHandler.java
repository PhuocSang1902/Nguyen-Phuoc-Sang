package com.example.maven.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//Có thêm @ControllerAdvice có thể trả về 1 view thay vì chỉ trả về 1 cấu trúc JSON
@RestControllerAdvice
public class CustomExceptionHandler {

    //Với mỗi exception sẽ có method handler riêng
    //Đây là method xử lý exception not found
    //@ExceptionHandler chỉ rõ method này xử lý exception nào
    //@ResponseStatus để định nghĩa status nào sẽ trả về cho người dùng
    //Method này sẽ có param là exception và web request
    //Trong hàm xử lý exception có thể thêm phần log lỗi vào, có thể tạo thành 1 method dùng chung tái sử dụng
    //Việc log lỗi quan trọng để lúc sau có thể phát hiện ra các lỗi trong hệ thống, lỗi có thể log vào trong database hoặc file
    //Nên tạo 1 handler để xử lý các exception chưa được khai bào, handler sẽ catch exception
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerException(Exception ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
