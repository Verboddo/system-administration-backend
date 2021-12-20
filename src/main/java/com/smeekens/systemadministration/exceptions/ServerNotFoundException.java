package com.smeekens.systemadministration.exceptions;

import java.io.Serial;

public class ServerNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ServerNotFoundException() {
        super ("Server not found");
    }
}
