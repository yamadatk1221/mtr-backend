package mtr_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthController {
    
    @GetMapping("/uchi")
    public String healthCheck() {
        return "うち〜〜〜";
    }
}
