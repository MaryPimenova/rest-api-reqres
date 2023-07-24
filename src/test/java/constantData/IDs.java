package constantData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IDs {
    EXPECTED_SINGLE_USER_ID(2),
    EXPECTED_FIRST_USER_ID(7),
    EXPECTED_LAST_USER_ID(12),
    EXPECTED_FIRST_COLOR_ID(1),
    EXPECTED_LAST_COLOR_ID(6);
    final Integer value;
}
