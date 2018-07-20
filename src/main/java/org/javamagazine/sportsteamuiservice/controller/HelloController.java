package org.javamagazine.sportsteamuiservice.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Example Mojarra CDI request-scoped controller.
 * @author juneau
 */
@Named
@RequestScoped
public class HelloController {

    private String name;
    private String message;

    public void createMessage() {
        message = "Hello, " + name + "!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

}
