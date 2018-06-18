package ru.ak.info;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ru.ak.emailvalidator.Validator;

/**
 * Корневой Web-сервис, содержащий метод получения версии
 * @author akakushin
 */

@WebService(name = "Info", serviceName = "Info", portName = "InfoPort") 
public class InfoService extends Validator {

    /**
     * Получение версии компоненты
     * @return Версия компоненты 
     */
    @WebMethod(operationName = "version")
    public String version() {
        return "1.0.0.1-3";
    }
}
