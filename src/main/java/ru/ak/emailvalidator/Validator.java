package ru.ak.emailvalidator;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.regex.Pattern;

/**
 * Web-сервис для проверки валидности адреса электронной почты
 *
 * @author akakushin
 */
@WebService(name = "EMailValidator", serviceName = "EMailValidator", portName = "EMailValidatorPort")
public class Validator {

    /**
     * Проверка валидности адреса электронной почты
     * @param email адрес
     * @return результат проверки
     */
    @WebMethod
    public boolean isValid(@WebParam(name = "email") String email) {
        boolean isValid = false;

        EmailValidator validator = new EmailValidator();
        Pattern ptr = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");

        isValid = validator.isValid(email, null);
        isValid = isValid && ptr.matcher(email).matches();

        return isValid;
    }
}
