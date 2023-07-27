package models.lombok;

import lombok.Data;

@Data
public class UserRegistrationResponseModel {
    private String token, ID, error;
}
