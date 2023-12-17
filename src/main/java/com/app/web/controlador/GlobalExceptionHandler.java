package com.app.web.controlador;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controlador de excepciones globales que maneja las excepciones de tipo DuplicatePatenteException.
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/* @param e La excepciÃ³n que se ha producido.
	*@return Un objeto ModelAndView que redirige a la vista "crear_vehiculo" con un mensaje de error.
	*/
    @ExceptionHandler(DuplicatePatenteException.class)
    public ModelAndView handleDuplicatePatenteException(DuplicatePatenteException e) {
        ModelAndView modelAndView = new ModelAndView("crear_vehiculo");
        modelAndView.addObject("error", e.getMessage());
        return modelAndView;
    }
}