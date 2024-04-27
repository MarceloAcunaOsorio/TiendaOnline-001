package com.tiendaonline.tienda.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFountException extends RuntimeException 
{
   public UsuarioNotFountException(String message)
   {
    super(message);
   }
}
