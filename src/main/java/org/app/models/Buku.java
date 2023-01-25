package org.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Buku extends BaseModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "buku_id", nullable = false)
    @NotNull(message = "Please provide id")
    public Long id;

    @Column(name = "name", length = 255)
    public String name;

    @Column(name = "author", length = 255)
    public String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sewa_buku_id", nullable = true)
    @JsonBackReference
    public SewaBuku sewaBuku;

    public SewaBuku getSewaBuku() {
        return sewaBuku;
    }

    public void setSewaBuku(SewaBuku sewaBuku) {
        this.sewaBuku = sewaBuku;
    }
}
