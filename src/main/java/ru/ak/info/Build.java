package ru.ak.info;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author a.kakushin
 */
public class Build {

    private String version;
    private String description;

    public Build() {}

    public Build(String version, String description) {
        this();
        this.version = version;
        this.description = description;
    }

    @XmlElement
    public String getVersion() {
        return version;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }
}