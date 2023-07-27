package models.lombok;

import lombok.Data;

@Data
public class UserLoginResponseModel {
    private String token, error;
}
