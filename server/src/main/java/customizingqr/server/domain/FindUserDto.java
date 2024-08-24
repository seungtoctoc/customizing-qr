package customizingqr.server.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FindUserDto {
    private String uuid;
    private String message;
    private LocalDateTime updatedAt;
}
