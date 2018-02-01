package com.MnP.demo.web.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
    public void testDelete() {
        final Bonbon bonbon = new Bonbon("789", "testDelete", "vert", Double.valueOf("4.7"), "sel,courge,carotte");
        bonbonDao.save(bonbon);
        bonbonDao.delete(bonbon.getId());
        Bonbon testBonbon = bonbonDao.findById(bonbon.getId());
        assertNull(testBonbon);
    }

    @Test
    public void testSave() {

        final Bonbon bonbon = new Bonbon("456", "testSave", "rouge", Double.valueOf("1.2"), "choux,citron,gingembre");
        bonbonDao.save(bonbon);
        final Bonbon testBonbon = bonbonDao.findById(bonbon.getId());
        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), bonbon.getComposition());
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
        bonbonDao.delete(bonbon.getId());
    }

    @Test
    public void testUpdate() {
        final Bonbon bonbon = new Bonbon("123", "saveUpdate", "bleu", Double.valueOf("5.3"), "sucre,vanille,amande");
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
        bonbonDao.delete(bonbon.getId());

    }
}
