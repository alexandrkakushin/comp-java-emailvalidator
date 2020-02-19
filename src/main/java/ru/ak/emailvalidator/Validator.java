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
     * 
     * @param email        адрес
     * @param domain2level обязательное наличие домена второго уровня (например,
     *                     test.com)
     * @return результат проверки
     */
    @WebMethod
    public boolean isValid(@WebParam(name = "email") String email,
            @WebParam(name = "domain2level") boolean domain2level) {
        boolean isValid;

        EmailValidator validator = new EmailValidator();
        isValid = validator.isValid(email, null);

        // Проверка на обязательное наличие домена второго уровня
        if (domain2level) {
            Pattern ptr = Pattern.compile("^[-\\w.]+@([-A-z0-9]+\\.)+[A-z]{2,4}$");
            isValid = isValid && ptr.matcher(email).matches();
        }

        return isValid;
    }
}
