package customizingqr.server.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserDto {
    private String ordererId;
    private String uuid;
    private String message;
    private LocalDateTime createdAt;
}
