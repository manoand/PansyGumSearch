package com.MnP.demo.web.service;

import java.util.List;

import com.MnP.demo.web.model.Bonbon;

public interface BonbonService {
    void delete(String id);

    List<Bonbon> findAll();

    Bonbon findById(String id);

    void save(Bonbon bonbon);

    void update(Bonbon bonbon);
}
