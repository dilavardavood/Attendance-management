package models;

import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIRequest {
    String userId;
    String orgId;
    String userName;
    String emailId;
}
