package org.app.services;

import javax.enterprise.context.ApplicationScoped;

import org.app.models.SewaBuku;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SewaBukuRepo implements PanacheRepository<SewaBuku> {
    
}
