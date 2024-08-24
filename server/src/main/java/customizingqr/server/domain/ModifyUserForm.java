package customizingqr.server.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ModifyUserForm {
    @NotBlank(message = "input uuid")
    private String uuid;

    @NotBlank(message = "input ordererId")
    private String ordererId;

    @NotBlank(message = "input message to modify")
    private String message;
}
