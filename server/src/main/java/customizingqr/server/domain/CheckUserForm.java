package customizingqr.server.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CheckUserForm {
    @NotBlank(message = "input uuid")
    private String uuid;

    @NotBlank(message = "input ordererId")
    private String ordererId;
}
