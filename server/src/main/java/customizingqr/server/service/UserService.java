package customizingqr.server.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.management.InstanceNotFoundException;

import org.springframework.stereotype.Service;

import customizingqr.server.domain.CheckUserForm;
import customizingqr.server.domain.CreateUserDto;
import customizingqr.server.domain.FindUserDto;
import customizingqr.server.domain.User;
import customizingqr.server.repository.UserJpaRepository;
import lombok.AllArgsConstructor;

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
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        User createdUser = userJpaRepository.save(userToCreate);
        createdUsers.add(createdUser.convertToCreateUserDto());

        response.put("orderedIds", orderedIds);
        response.put("createdUsers", createdUsers);

        return response;
    }

    // 조회
    public FindUserDto findUserWithUuid(String uuid) throws InstanceNotFoundException {
        Optional<User> userToFind = userJpaRepository.findByUuid(uuid);

        if (userToFind.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        return userToFind.get().convertToFindUserDto();
    }

    // uuid, id로 조회
    public Boolean checkUser(CheckUserForm checkUserForm) throws InstanceNotFoundException {
        Optional<User> userToFind = userJpaRepository.findByUuid(checkUserForm.getUuid());

        if (userToFind.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        if (checkUserForm.getOrdererId().equals(userToFind.get().getOrdererId())) {
            return true;
        }

        return false;
    }
}
