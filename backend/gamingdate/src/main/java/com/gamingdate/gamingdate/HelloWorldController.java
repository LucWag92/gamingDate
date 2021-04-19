package com.gamingdate.gamingdate;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @CrossOrigin(origins = "http://localhost:4200") // needed to be able to call from flutter web
    @PostMapping("/accountdata")
    public String index(@RequestBody int id) {
        System.out.println(id);
        if (id == 0) {
            return "id was 0";
        }
        return "id was not 0";

    }
}
