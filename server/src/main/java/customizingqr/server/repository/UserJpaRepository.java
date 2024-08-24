package customizingqr.server.repository;

import java.util.Optional;

import customizingqr.server.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUuid(String uuid);

    Optional<User> findByUuidAndOrdererId(String uuid, String ordererId);
}
