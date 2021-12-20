package com.smeekens.systemadministration.exceptions;

import java.io.Serial;

public class ServerAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ServerAlreadyExistsException() {
        super ("Server already exists");
    }
}
