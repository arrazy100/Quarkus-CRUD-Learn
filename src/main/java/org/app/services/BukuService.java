package org.app.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.app.responses.BukuResponse;
import org.app.responses.ListBukuResponse;
import org.app.responses.SimpleResponse;
import org.app.interfaces.IBukuService;
import org.app.models.Buku;
import org.app.models.dto.BukuDTO;
import org.app.models.mappers.BukuMapper;
import org.app.requests.BukuRequest;

@ApplicationScoped
public class BukuService implements IBukuService {
    @Inject
    EntityManager em;

    @Inject
    BukuMapper bukuMapper;

    @Transactional
    public SimpleResponse createBook(BukuRequest body) {
        Buku buku = new Buku();
        buku.name = body.name;
        buku.author = body.author;

        buku.persist();

        return new SimpleResponse(200, "SUCCESS", buku.id);
    }

    public BukuResponse getBook(Long id) {
        Buku buku = Buku.findById(id);

        return new BukuResponse(200, "SUCCESS", buku.id, buku.name, buku.author);
    }

    public ListBukuResponse getAllBooks() {
        List<BukuDTO> bukuList = bukuMapper.toDtoList(Buku.listAll());

        return new ListBukuResponse(200, "SUCCESS", bukuList);
    }

    @Transactional
    public BukuResponse updateBook(Long id, BukuRequest body) {
        Buku buku = Buku.findById(id);

        if (body.name != null) {
            buku.name = body.name;
        }

        if (body.author != null) {
            buku.author = body.author;
        }

        buku.persist();

        return new BukuResponse(200, "SUCCESS", buku.id, buku.name, buku.author);
    }

    @Transactional
    public SimpleResponse deleteBook(Long id) {
        Buku buku = Buku.findById(id);
        buku.delete();

        return new SimpleResponse(204, "DELETED", id);
    }
}
