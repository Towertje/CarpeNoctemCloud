package org.carpenoctemcloud.exceptionMappers;

import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DatabaseErrorMapper {

    Logger logger = LoggerFactory.getLogger(DatabaseErrorMapper.class);

    @ExceptionHandler(JDBCException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse databaseExceptionHandler(ConstraintViolationException e) {
        logger.error(e.toString());
        return ErrorResponse.create(e, HttpStatus.BAD_REQUEST,
                                    "Error because a constraint was violated when accessing the database.");
    }
}
