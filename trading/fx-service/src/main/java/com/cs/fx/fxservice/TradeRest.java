package com.cs.fx.fxservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz on 06.07.2017.
 */
@RestController
public class TradeRest {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

}
