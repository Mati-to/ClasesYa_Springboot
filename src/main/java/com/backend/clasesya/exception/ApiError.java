package com.backend.clasesya.exception;

public record ApiError(
    int status,
    String message,
    String path
) { }
