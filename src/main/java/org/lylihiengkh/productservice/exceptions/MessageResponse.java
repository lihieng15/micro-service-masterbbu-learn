package org.lylihiengkh.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse <T>{
    private T data;
    private boolean success;
    private String message;
    private String errorCode;
    public MessageResponse(){

    }
    public MessageResponse(T data, boolean success, String message, String errorCode){
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
        this.success = success;
    }
}
