package com.MnP.demo.web.service.implementation;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.client.RestHighLevelClient;
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
    public void delete(final String id) {
        bonbonDao.delete(id);
    }

    @Override
    public List<Bonbon> findAll() {
        return bonbonDao.findAll();
    }

    @Override
    public Bonbon findById(final String id) {
        return bonbonDao.findById(id);
    }

    @PostConstruct
    public void initBd() {
        bonbonDao.save(new Bonbon("1", "Tête brulée", "rouge", Double.valueOf("3.8"), "sucre,vanille,amande"));
        bonbonDao
            .save(new Bonbon("2", "Coca Cola", "noir,rouge,transparent", Double.valueOf("5.25"), "sucre,vanille,amande"));
        bonbonDao.save(new Bonbon("3", "Oeuf", "blanc,jaune", Double.valueOf("1.02"), "sucre,vanille,amande"));
    }

    @Override
    public void save(final Bonbon bonbon) {
        bonbonDao.save(bonbon);
    }

    @Override
    public void update(final Bonbon bonbon) {
        bonbonDao.update(bonbon);
    }
    
    @Override
    public void closeClient(RestHighLevelClient client) {
        try {
            client.close();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
