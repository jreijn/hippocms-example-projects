package org.example.spring;

public class HelloServiceImpl implements HelloService {

    private String globalMessage = "Hello";

    public String getGlobalMessage() {
        return globalMessage;
    }

    public void setGlobalMessage(final String globalMessage) {
        this.globalMessage = globalMessage;
    }

    public String getHelloMessage(String name) {
        if (name == null) {
            return globalMessage;
        } else {
            return globalMessage + " " +name;
        }

    }

}