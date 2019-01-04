package itsgosho.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Sorry ,but this page wasn't found!")
public class PageNotFoundException extends RuntimeException {

}
