package com.github.tadayosi;

import org.apache.camel.*;
import org.apache.camel.builder.*;
import org.apache.camel.main.*;
import org.apache.camel.spi.*;
import static org.apache.camel.builder.PredicateBuilder.*;

public class GreetingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().port(8080);

        rest()
            .get("/hello/{name}").to("direct:hello")
            .get("/bye/{name}").to("direct:bye");

        from("direct:hello")
            .log("Hello: ${header.name}")
            .transform().simple("Hello ${header.name}!");
        from("direct:bye")
            .log("Bye:   ${header.name}")
            .transform().simple("Bye ${header.name}!");
    }
}
