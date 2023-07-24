package constantData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseData {
    EXPECTED_TOKEN("QpwL5tke4Pnpja7X4"),
    EXPECTED_ID("4");
    final String value;
}
