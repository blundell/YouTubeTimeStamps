package com.blundell.tut;

import java.util.Date;

class Comment {

    private final Date timestamp;
    private final String message;

    public Comment(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
