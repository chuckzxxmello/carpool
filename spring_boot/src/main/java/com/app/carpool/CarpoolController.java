package com.app.carpool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarpoolController {

    @GetMapping("/")
    public String home() {
        return "angular-test";
    }
}
