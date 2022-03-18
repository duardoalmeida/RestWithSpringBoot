package br.com.restwithspringboot.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private Date timeStDate;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStDate, String message, String details) {
        this.timeStDate = timeStDate;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStDate() {
        return timeStDate;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
