package com.MnP.demo.web.dao;

import com.MnP.demo.web.model.Bonbon;

public interface BonbonDao {
    void delete(Bonbon bonbon);

    Iterable<Bonbon> findAll();

    Bonbon findById(Long id);

    void save(Bonbon bonbon);

    void update(Bonbon bonbon);

}
