package customizingqr.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customizingqr.server.domain.CreateUserDto;
import customizingqr.server.domain.FindUserDto;
import customizingqr.server.service.UserService;
import customizingqr.server.utils.ApiUtils;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("")
//@CrossOrigin("http://localhost:5173")
@CrossOrigin("http://localhost")
public class UserController {

    private final UserService userService;

    @GetMapping("/create/test")
    public ApiUtils.ApiResult<Object> index() {
        Map<String, Object> result = userService.createUser();

        if (result == null) {
            return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ApiUtils.success(result);
    }

    // uuid로 user 조회
    @GetMapping("/user")
    public ApiUtils.ApiResult<FindUserDto> findUser(@RequestParam("uuid") String uuid) {

        return null;
    }

    // 수정

}
