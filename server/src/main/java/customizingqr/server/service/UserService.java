package customizingqr.server.service;

import customizingqr.server.domain.CreateUserDto;
import customizingqr.server.domain.FindUserDto;
import customizingqr.server.domain.ModifyUserForm;
import customizingqr.server.domain.User;
import customizingqr.server.repository.UserJpaRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.management.InstanceNotFoundException;

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

        if (userToFind == null) {
            return null;
        }

        if (userToFind.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        return userToFind.get().convertToFindUserDto();
    }

    // 수정
    public FindUserDto modifyUser(ModifyUserForm modifyUserForm) throws InstanceNotFoundException {
        Optional<User> userToModify = userJpaRepository.findByUuid(modifyUserForm.getUuid());

        if (userToModify == null) {
            return null;
        }

        if (userToModify.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        if (!userToModify.get().getOrdererId().equals(modifyUserForm.getOrdererId())) {
            throw new IllegalArgumentException();
        }

        userToModify.get().setMessage(modifyUserForm.getMessage());
        userToModify.get().setUpdatedAt(LocalDateTime.now());

        User modifiedUser = userJpaRepository.save(userToModify.get());

        if (modifiedUser == null) {
            return null;
        }

        return modifiedUser.convertToFindUserDto();
    }
}
