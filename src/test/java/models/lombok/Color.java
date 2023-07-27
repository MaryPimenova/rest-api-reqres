package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {
    private Integer ID;
    private String name;
    private String year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}