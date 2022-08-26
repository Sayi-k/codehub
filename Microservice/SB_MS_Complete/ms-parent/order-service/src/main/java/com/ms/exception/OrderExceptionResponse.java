package com.ms.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderExceptionResponse {
    private String message;
    private String errorCodeMessage;
}
