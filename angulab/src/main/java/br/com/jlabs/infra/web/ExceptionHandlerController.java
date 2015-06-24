package br.com.jlabs.infra.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.jlabs.infra.rest.ApplicationError;
import br.com.jlabs.infra.rest.RestResponse;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.ACCEPTED)
    public @ResponseBody RestResponse handleError(HttpServletRequest req, Exception exception) {

        return RestResponse.error(ApplicationError.fromException(exception));
        
    }
}
