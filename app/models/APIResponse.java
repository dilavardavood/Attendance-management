package models;

import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {
StatusInfo statusInfo;

Object responseData;


}
