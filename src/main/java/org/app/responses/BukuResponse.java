package org.app.responses;

public class BukuResponse extends BaseResponse {
    public Long id;
    public String name;
    public String author;

    public BukuResponse(int status, String message, Long id, String name, String author) {
        this.status = status;
        this.message = message;
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
