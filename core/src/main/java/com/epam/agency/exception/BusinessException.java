package com.epam.agency.exception;

import com.epam.agency.exception.type.BusinessExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private BusinessExceptionCode code;
}
