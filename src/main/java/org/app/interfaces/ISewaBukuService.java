package org.app.interfaces;

import org.app.requests.SewaBukuRequest;
import org.app.responses.SewaBukuResponse;
import org.app.responses.SimpleResponse;

public interface ISewaBukuService {
    SimpleResponse createSewaBuku(SewaBukuRequest body);
    SewaBukuResponse getSewaBuku(Long id);
    SewaBukuResponse addBuku(Long id, Long bukuId);
}
