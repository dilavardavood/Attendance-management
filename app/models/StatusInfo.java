package models;

import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusInfo {
    private String statusCode;
    private String statusMessage;
}
