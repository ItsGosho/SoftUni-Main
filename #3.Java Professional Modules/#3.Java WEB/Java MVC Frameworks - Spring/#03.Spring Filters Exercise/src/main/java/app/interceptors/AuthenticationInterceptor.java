package app.interceptors;

import app.controllers.PreAuthenticate;
import app.db.models.User;
import app.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(modelAndView!=null) {
            if (handlerMethod.getMethod().isAnnotationPresent(PreAuthenticate.class)) {
                String requiredRole = handlerMethod.getMethod().getAnnotation(PreAuthenticate.class).inRole();
                boolean neededToBeLogged = handlerMethod.getMethod().getAnnotation(PreAuthenticate.class).loggedIn();
                if (neededToBeLogged) {
                    if(request.getSession().getAttribute("username") != null){
                        User user = this.userRepository.findUserByUsername((String) request.getSession().getAttribute("username"));
                        String defaultRoleValue="GUEST";
                        if (user.getRole().equals(requiredRole)) {
                            //PROCESS
                            super.postHandle(request, response, handler, modelAndView);
                        }else{
                            //not speciefied role
                            if(requiredRole.equals(defaultRoleValue)){
                                super.postHandle(request, response, handler, modelAndView);
                            }else{
                                modelAndView.setViewName("/errors/pre-authenticate");
                            }
                        }
                    }else{
                        modelAndView.setViewName("/errors/pre-authenticate");
                    }
                }else {
                    if(request.getSession().getAttribute("username")==null){
                        super.postHandle(request, response, handler, modelAndView);
                    }else{
                        modelAndView.setViewName("/errors/pre-authenticate");
                    }
                }
            }
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
