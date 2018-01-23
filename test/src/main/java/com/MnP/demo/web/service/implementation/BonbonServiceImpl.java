package com.MnP.demo.web.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.repository.BonbonRepository;
import com.MnP.demo.web.service.BonbonService;

@Service
public class BonbonServiceImpl implements BonbonService {

    private BonbonRepository bonbonRepository;

    @Override
    public void delete(final Bonbon bonbon) {
        bonbonRepository.delete(bonbon);
    }

    @Override
    public Iterable<Bonbon> findAll() {
        return bonbonRepository.findAll();
    }

    @Override
    public Bonbon findById(final Long id) {
        return bonbonRepository.findById(id);
    }

    @Override
    public Bonbon findOne(final Long id) {
        return bonbonRepository.findOne(id);
    }

    @Override
    public Bonbon save(final Bonbon bonbon) {
        return bonbonRepository.save(bonbon);
    }

    @Autowired
    public void setBookRepository(final BonbonRepository bonbonRepository) {
        this.bonbonRepository = bonbonRepository;
    }

}
