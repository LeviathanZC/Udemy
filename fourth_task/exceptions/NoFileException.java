package com.company.epam.fourth_task.exceptions;

import java.io.IOException;

public class NoFileException extends Exception {

    public NoFileException(String message, IOException e) {
        super(message,e);

    }

}
