package customizingqr.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
//@CrossOrigin
public class MainController {

    @GetMapping("/test")
    public String index() {
        return "success";
    }
}
