package com.gamingdate.gamingdate;


import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@RestController
public class GamingDateController {
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
    @CrossOrigin(origins = "http://localhost:4200") // needed to be able to call from flutter web
    @GetMapping("/user")
    public String index(@RequestBody UUID userId) {
        return userId.toString();
    }
}
