package com.example.usuario.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException (String detail){
        super(detail);
    }


}
