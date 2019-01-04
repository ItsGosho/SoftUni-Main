package itsgosho.controllers;

import itsgosho.errors.PageNotFoundException;
import itsgosho.errors.UnauthorizedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView unauthorized(){

        return super.view("error/403");
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ModelAndView notFound(){

        return super.view("error/404");
    }
}
