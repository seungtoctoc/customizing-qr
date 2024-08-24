package customizingqr.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.InstanceNotFoundException;

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
    public ApiUtils.ApiResult<Object> findUserWithUuid(@RequestParam("uuid") String uuid) {
        try {
            FindUserDto result = userService.findUserWithUuid(uuid);

            if (result == null) {
                return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ApiUtils.success(result);

        } catch (InstanceNotFoundException e) {
            return ApiUtils.error("can not find user", HttpStatus.BAD_REQUEST);
        }
    }

    // 수정

}
