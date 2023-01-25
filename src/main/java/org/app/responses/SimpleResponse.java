package org.app.responses;

public class SimpleResponse extends BaseResponse {
    public Long id;

    public SimpleResponse(int status, String message, Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }
}
