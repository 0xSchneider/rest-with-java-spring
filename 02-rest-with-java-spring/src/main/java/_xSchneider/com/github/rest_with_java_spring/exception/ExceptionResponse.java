package _xSchneider.com.github.rest_with_java_spring.exception;

import _xSchneider.com.github.rest_with_java_spring.model.Greeting;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
