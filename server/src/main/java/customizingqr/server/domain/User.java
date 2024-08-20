package customizingqr.server.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ordererId;
    private String uuid;
    private String message;
    private Boolean setImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
