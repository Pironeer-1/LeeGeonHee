package com.pironeer._th.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private Exception originException;
  private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.errorCode = errorCode;
    }

    public CustomException(Exception originException, ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.originException = originException;
      this.errorCode = errorCode;
    }

}
