package com.lightside.fg.web.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * @author Anwar
 */

@Builder
@ToString
@EqualsAndHashCode(of = "errorCode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Comparable<ApiError> {
    private String errorCode;
    private String errorMessage;

    @JsonIgnore
    public static ApiError buildError(String errorCode, String errorMessage) {
        return new ApiError(errorCode, errorMessage);
    }

    @JsonIgnore
    @Override
    public int compareTo(ApiError o) {
        if (o == null) {
            return 1;
        }
        if (errorCode == null) {
            return -1;
        }
        return errorCode.compareTo(o.errorCode);
    }
}
