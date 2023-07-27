package models.lombok;

import lombok.Data;

@Data
public class UserLoginAndRegistrationRequestModel {
    private String email, password;
}
