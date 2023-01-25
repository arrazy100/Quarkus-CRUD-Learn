package org.app.responses;

import java.util.List;

import org.app.models.dto.BukuDTO;

public class SewaBukuResponse extends BaseResponse {
    public Long id;
    public List<BukuDTO> daftar;

    public SewaBukuResponse(int status, String message, Long id, List<BukuDTO> daftar) {
        this.status = status;
        this.message = message;
        this.id = id;
        this.daftar = daftar;
    }
}
