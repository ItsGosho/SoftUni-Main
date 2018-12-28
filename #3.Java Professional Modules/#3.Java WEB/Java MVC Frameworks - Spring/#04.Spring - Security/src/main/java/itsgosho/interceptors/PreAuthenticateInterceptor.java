package itsgosho.interceptors;

import itsgosho.config.validators.preAuthenticate.PreAuthenticate;
import itsgosho.domain.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class PreAuthenticateInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getSession();
        boolean result = true;
        if(handler instanceof HandlerMethod){
            Method requestedMethod =  ((HandlerMethod) handler).getMethod();
            Class<?> requestClass = ((HandlerMethod) handler).getMethod().getDeclaringClass();

            if(requestedMethod.isAnnotationPresent(PreAuthenticate.class)){
                PreAuthenticate preAuthenticate = requestedMethod.getAnnotation(PreAuthenticate.class);
                result = proceedAuthentication(request,preAuthenticate);
            }else if(requestClass.isAnnotationPresent(PreAuthenticate.class)){
                PreAuthenticate preAuthenticate = requestClass.getAnnotation(PreAuthenticate.class);
                result = proceedAuthentication(request,preAuthenticate);
            }
        }
        if(!result){
            response.sendRedirect("/");
        }
        return result;
    }

    public boolean proceedAuthentication(HttpServletRequest request,PreAuthenticate preAuthenticate){
        User user = (User) request.getSession().getAttribute("user");

        if(preAuthenticate.loggedIn()){
            if(user!=null){

//                int userRole = user.getUserRole().ordinal();
//                int requiredRole = UserRoles.valueOf(preAuthenticate.inRole()).ordinal();
//
//                if(userRole>=requiredRole){
//                    return true;
//                }
            }
        }else{
            if(user==null){
                return true;
            }
        }
        return false;
    }
}
