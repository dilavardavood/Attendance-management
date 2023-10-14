package models;

import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusInfo {
    String statusCode;
    String statusMessage;
    String errorMessage;
}
