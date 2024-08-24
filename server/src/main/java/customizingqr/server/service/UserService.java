package customizingqr.server.service;

import customizingqr.server.domain.CreateUserDto;
import customizingqr.server.domain.User;
import customizingqr.server.repository.UserJpaRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private UserJpaRepository userJpaRepository;

    // 주문 조회, 생성 (스케줄)
    public Map<String, Object> createUser() {
        Map<String, Object> response = new LinkedHashMap<>();

        List<String> orderedIds = new ArrayList<>();
        List<CreateUserDto> createdUsers = new ArrayList<>();

        // 주문 조회
        // orderedIds (test)
        orderedIds.add("test_order_id");

        // 주문 있다면 User 생성
        User userToCreate = User.builder()
            .ordererId("test_orderer_id")
            .uuid(UUID.randomUUID().toString())
            .message("test_message")
            .build();

        User createdUser = userJpaRepository.save(userToCreate);
        createdUsers.add(createdUser.convertToCreateUserDto());

        response.put("orderedIds", orderedIds);
        response.put("createdUsers", createdUsers);

        return response;
    }

    // 수정

    // 조회
}
