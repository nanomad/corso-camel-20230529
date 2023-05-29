package com.example.camelvanilla;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CamelVanillaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CamelVanillaApplication.class);
    public static void main(String[] args) throws Exception {

        Main main = new Main();

        main.configure().addRoutesBuilder( new MyRouteBuilder());

        LOGGER.info("CIAO");
        main.run();
    }

}
