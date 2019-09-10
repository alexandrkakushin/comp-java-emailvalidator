package ru.ak.info;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

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
        return builds().size() == 0 ? "null" : builds().get(builds().size() - 1).getVersion();
    }

    /** 
    * Получение списка изменений компоненты
    * @return Список
    */
    @WebMethod(operationName = "details") 
    public Builds details() {
        return new Builds(builds());
    }

    public static class Builds {
        private List<Build> builds;

        public Builds(List<Build> builds) {
            this.builds = builds;
        }

        @XmlElement
        public List<Build> getBuilds() {
            return builds;
        }
    }
    
    private List<Build> builds() {
        List<Build> builds = new ArrayList<>();
        builds.add(            
            new Build("1.0.0.1", description_1_0_0_1()));

        builds.add(            
            new Build("1.0.0.2", description_1_0_0_2()));
    
        return builds;
    }

    private String description_1_0_0_1() {
        return "Создание проекта";
    }

    private String description_1_0_0_2() {
        return "Миграция на Java 11, рефакторинг проекта";
    }
}