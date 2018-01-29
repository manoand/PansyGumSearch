package com.MnP.demo.web.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MnP.demo.web.DemoApplication;
import com.MnP.demo.web.dao.BonbonDao;
import com.MnP.demo.web.model.Bonbon;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BonbonDaoTest {
    @Autowired
    private BonbonDao bonbonDao;

    @Test
    public void testSave() {

        final Bonbon bonbon = new Bonbon(Long.valueOf("1234"), "bonbonTest", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande");
        bonbonDao.save(bonbon);
        final Bonbon testBonbon = bonbonDao.findById(bonbon.getId());
        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), bonbon.getComposition());
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
    }

    @Test
    public void testUpdate() {
        final Bonbon bonbon = new Bonbon(Long.valueOf("456"), "bonbonTest", "bleu", Double.valueOf("5.3"), "sucre,vanille,amande");
        bonbonDao.save(bonbon);
        bonbon.setComposition("beurre,bacon,babouin");
        bonbonDao.update(bonbon);
        final Bonbon testBonbon = bonbonDao.findById(bonbon.getId());

        bonbonDao.update(bonbon);
        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), "beurre,bacon,babouin");
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
    }
}
