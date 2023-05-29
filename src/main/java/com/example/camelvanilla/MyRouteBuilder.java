package com.example.camelvanilla;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.util.Locale;

public class MyRouteBuilder extends RouteBuilder {

    static class MyBean {
        public String setToUpperCase(String message) {
            return message.toUpperCase(Locale.ENGLISH);
        }
    }
    @Override
    public void configure() throws Exception {
        onException(Exception.class).maximumRedeliveries(1);

        from("file:input?backoffErrorThreshold=10")
                .log(LoggingLevel.INFO, "Ricevuto un nuovo file: ${header.CamelFileNameOnly}")
                .convertBodyTo(String.class)
                .bean(new MyBean(), "setToUpperCase(${body}})")
                .to("file:output")
                .log("File ${header.CamelFileNameOnly} spostato correttamente");
    }
}
