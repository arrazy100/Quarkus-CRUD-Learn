package org.app.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.app.interfaces.ISewaBukuInterface;
import org.app.models.Buku;
import org.app.models.SewaBuku;
import org.app.models.dto.BukuDTO;
import org.app.models.mappers.BukuMapper;
import org.app.requests.SewaBukuRequest;
import org.app.responses.SewaBukuResponse;
import org.app.responses.SimpleResponse;

@ApplicationScoped
public class SewaBukuService implements ISewaBukuInterface {
    @Inject
    EntityManager em;

    @Inject
    SewaBukuRepo sewaBukuRepo;

    @Inject
    BukuMapper bukuMapper;

    @Transactional
    public SimpleResponse createSewaBuku(SewaBukuRequest body) {
        SewaBuku sewaBuku = new SewaBuku();

        for (Buku buku: body.daftar) {
            buku.sewaBuku = sewaBuku;
        }

        sewaBuku.setDaftar(body.daftar);

        sewaBuku.persist();

        return new SimpleResponse(200, "SUCCESS", sewaBuku.id);
    }

    public SewaBukuResponse getSewaBuku(Long id) {
        SewaBuku sewaBuku = SewaBuku.findById(id);
        List<BukuDTO> daftar = bukuMapper.toDtoList(sewaBuku.getDaftar());

        return new SewaBukuResponse(200, "SUCCESS", id, daftar);
    }

    @Transactional
    public SewaBukuResponse addBuku(Long id, Long bukuId) {
        Buku buku = Buku.findById(bukuId);
        SewaBuku sewaBuku = SewaBuku.findById(id);
        sewaBuku.getDaftar().add(buku);

        buku.sewaBuku = sewaBuku;

        buku.persist();
        sewaBuku.persist();

        List<BukuDTO> daftar = bukuMapper.toDtoList(sewaBuku.getDaftar());

        return new SewaBukuResponse(200, "SUCCESS", id, daftar);
    }
}
