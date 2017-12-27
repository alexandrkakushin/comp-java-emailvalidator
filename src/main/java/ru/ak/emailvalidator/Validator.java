package ru.ak.emailvalidator;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
          EmailValidator validator = new EmailValidator();
          return validator.isValid(email, null);
    }
}
