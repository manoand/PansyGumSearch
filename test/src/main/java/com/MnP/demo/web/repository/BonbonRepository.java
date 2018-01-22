package com.MnP.demo.web.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.MnP.demo.web.model.Bonbon;

public interface BonbonRepository extends ElasticsearchRepository<Bonbon, Long> {
    Bonbon findById(Long id);
}
