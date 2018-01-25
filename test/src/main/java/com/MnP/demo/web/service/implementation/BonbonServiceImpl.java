package com.MnP.demo.web.service.implementation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MnP.demo.web.dao.BonbonDao;
import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@Service
public class BonbonServiceImpl implements BonbonService {

    @Autowired
    BonbonDao bonbonDao;

    @Override
    public void delete(final Bonbon bonbon) {
        bonbonDao.delete(bonbon);
    }

    @Override
    public Iterable<Bonbon> findAll() {
        return bonbonDao.findAll();
    }

    @Override
    public Bonbon findById(final Long id) {
        return bonbonDao.findById(id);
    }

    @Override
    public Bonbon save(final Bonbon bonbon) {
        return bonbonDao.save(bonbon);
    }
    
    @PostConstruct
    public void initBd() {
    	bonbonDao.save(new Bonbon(Long.valueOf("1"), "Tête brulée", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande"));
    	bonbonDao.save(new Bonbon(
            Long.valueOf("2"),
            "Cocoa",
            "noir,rouge,transparent",
            Double.valueOf("1.2"),
            "sucre,vanille,amande"));
    	bonbonDao.save(new Bonbon(Long.valueOf("3"), "Oeuf", "blanc,jaune", Double.valueOf("1.2"), "sucre,vanille,amande"));
    }

}
