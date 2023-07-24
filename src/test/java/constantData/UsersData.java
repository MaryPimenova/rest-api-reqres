package constantData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum UsersData {
    USER_NAME("morpheus"),
    USER_FIRST_JOB("zion resident"),
    USER_SECOND_JOB("leader"),
    USER_FIRST_EMAIL("eve.holt@reqres.in"),
    USER_SECOND_EMAIL("peter@klaven"),
    USER_THIRD_EMAIL("sydney@fife"),
    USER_FIRST_PASSWORD("cityslicka"),
    USER_SECOND_PASSWORD("pistol"),
    EXPECTED_LAST_NAME_OF_FIRST_USER("Lawson"),
    EXPECTED_LAST_NAME_OF_LAST_USER("Howell"),
    EXPECTED_SINGLE_USER_LAST_NAME("Weaver");
    final String value;
}
