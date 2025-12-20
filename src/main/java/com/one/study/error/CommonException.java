package com.one.study.error;

import lombok.*;

@Getter
@AllArgsConstructor
public class CommonException extends RuntimeException{

    private ErrorCode errorCode;

}
