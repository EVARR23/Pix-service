package com.bootcamp.pix_service.configuration;

import com.bootcamp.pix_service.exception.ChaveJaCadastradaException;
import com.bootcamp.pix_service.exception.ChaveNaoLocalizadaException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ChaveJaCadastradaException.class)
    public ProblemDetail handleChaveJaCadastrada(ChaveJaCadastradaException chaveException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, chaveException.getMessage());
        problemDetail.setTitle("Chave duplicada");
        problemDetail.setType(URI.create("http://localhost:9002/document/chave-ja-cadastrada"));
        return problemDetail;
    }

    @ExceptionHandler(ChaveNaoLocalizadaException.class)
    public ProblemDetail handleChaveJaCadastrada(ChaveNaoLocalizadaException chaveException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, chaveException.getMessage());
        problemDetail.setTitle("Chave duplicada");
        problemDetail.setType(URI.create("http://localhost:9002/document/chave-ja-cadastrada"));
        return problemDetail;
    }

}
