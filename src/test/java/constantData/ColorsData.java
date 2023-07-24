package constantData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ColorsData {
    EXPECTED_NAME_OF_FIRST_COLOR("cerulean"),
    EXPECTED_NAME_OF_LAST_COLOR("blue turquoise");
    final String value;
}
