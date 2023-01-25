package org.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SewaBuku extends BaseModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "sewa_buku_id", nullable = false)
    @NotNull(message = "Please provide id")
    public Long id;

    @OneToMany(mappedBy = "sewaBuku", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<Buku> daftar = new ArrayList<>();

    public List<Buku> getDaftar() {
        return daftar;
    }

    public void setDaftar(List<Buku> daftar) {
        this.daftar = daftar;
    }

    public void addBuku(Buku buku) {
        daftar.add(buku);
    }
}
