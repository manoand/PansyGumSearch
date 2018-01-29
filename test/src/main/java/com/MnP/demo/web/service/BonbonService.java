package com.MnP.demo.web.service;

import com.MnP.demo.web.model.Bonbon;

public interface BonbonService {
    void delete(Bonbon bonbon);

    Iterable<Bonbon> findAll();

    Bonbon findById(Long id);

    void save(Bonbon bonbon);

    void update(Bonbon bonbon);
}
