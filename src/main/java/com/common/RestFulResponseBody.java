package com.common;

import org.springframework.http.HttpStatus;

public class RestFulResponseBody {

    String message;
    HttpStatus httpStatus;
    Object []data;

    public RestFulResponseBody(){}

    public RestFulResponseBody(String message, HttpStatus httpStatus, Object...data){
        this.data=data;
        this.message=message;
        this.httpStatus=httpStatus;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
