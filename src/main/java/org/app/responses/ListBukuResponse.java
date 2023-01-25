package org.app.responses;

import java.util.List;

import org.app.models.dto.BukuDTO;

public class ListBukuResponse extends BaseResponse {
    public List<BukuDTO> daftar;

    public ListBukuResponse(int status, String message, List<BukuDTO> daftar) {
        this.status = status;
        this.message = message;
        this.daftar = daftar;
    }
}
