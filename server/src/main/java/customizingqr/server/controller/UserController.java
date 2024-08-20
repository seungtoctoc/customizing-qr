package customizingqr.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
//@CrossOrigin
public class UserController {
    @GetMapping("/test")
    public String index() {
        return "success";
    }

    // url로 user 조회

    // 생성

    // 수정
}
