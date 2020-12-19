package com.bloomberg.clustereddata.advise;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse {

    private ErrorCode error;
    private String message;
    private List<String> errorMessages;
}
