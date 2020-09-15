package com.karthi.rest.exceptions;

import org.springframework.boot.ExitCodeExceptionMapper;

public class StudentNotFoundExceptionMapper implements ExitCodeExceptionMapper {
    @Override
    public int getExitCode(Throwable exception) {
        return 404;
    }
}
