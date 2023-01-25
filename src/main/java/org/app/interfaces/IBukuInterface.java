package org.app.interfaces;

import org.app.responses.SimpleResponse;
import org.app.responses.BukuResponse;
import org.app.responses.ListBukuResponse;
import org.app.requests.BukuRequest;

public interface IBukuInterface {
    SimpleResponse createBook(BukuRequest body);
    BukuResponse getBook(Long id);
    ListBukuResponse getAllBooks();
    BukuResponse updateBook(Long id, BukuRequest body);
    SimpleResponse deleteBook(Long id);
}
