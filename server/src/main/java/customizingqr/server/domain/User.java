package customizingqr.server.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ordererId;
    private String uuid;
    private String message;
    private Integer textSize;
    private Integer textStyle;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CreateUserDto convertToCreateUserDto() {
        return new CreateUserDto(ordererId, uuid, message, createdAt);
    }

    public FindUserDto convertToFindUserDto() {
        return new FindUserDto(uuid, message, updatedAt);
    }
}
