package com.MnP.demo.web.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.MnP.demo.web.DemoApplication;
import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BonbonSeriviceTest {
    @Autowired
    private BonbonService bonbonService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Bonbon.class);
        esTemplate.createIndex(Bonbon.class);
        esTemplate.putMapping(Bonbon.class);
        esTemplate.refresh(Bonbon.class);
    }

    @Test
    public void testDelete() {

        final Bonbon bonbon = new Bonbon(Long.valueOf("1234"), "bonbonTest", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande");
        bonbonService.save(bonbon);
        bonbonService.delete(bonbon);
        final Bonbon testBonbon = bonbonService.findOne(bonbon.getId());
        assertNull(testBonbon);
    }

    @Test
    public void testFindById() {

        final Bonbon bonbon = new Bonbon(Long.valueOf("1234"), "bonbonTest", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande");
        bonbonService.save(bonbon);

        final Bonbon testBonbon = bonbonService.findById(bonbon.getId());
        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), bonbon.getComposition());
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
    }

    @Test
    public void testFindOne() {

        final Bonbon bonbon = new Bonbon(Long.valueOf("1234"), "bonbonTest", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande");
        bonbonService.save(bonbon);

        final Bonbon testBonbon = bonbonService.findOne(bonbon.getId());
        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), bonbon.getComposition());
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
    }

    @Test
    public void testSave() {

        final Bonbon bonbon = new Bonbon(Long.valueOf("1234"), "bonbonTest", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande");
        final Bonbon testBonbon = bonbonService.save(bonbon);

        assertNotNull(testBonbon.getId());
        assertEquals(testBonbon.getId(), bonbon.getId());
        assertEquals(testBonbon.getComposition(), bonbon.getComposition());
        assertEquals(testBonbon.getNom(), bonbon.getNom());
        assertEquals(testBonbon.getPoids(), bonbon.getPoids());
        assertEquals(testBonbon.getCouleur(), bonbon.getCouleur());
    }
}
