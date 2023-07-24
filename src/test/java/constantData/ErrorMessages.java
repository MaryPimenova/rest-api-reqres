package constantData;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor

public enum ErrorMessages {
    MISSING_PASSWORD("Missing password"),
    MISSING_EMAIL_OR_USERNAME("Missing email or username");
    final String value;
}
