package com.MnP.demo.web.dao.implementation;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.stereotype.Service;

import com.MnP.demo.web.dao.BonbonDao;
import com.MnP.demo.web.model.Bonbon;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BonbonDaoImpl implements BonbonDao {

    
    @Override
    public void delete(final Bonbon bonbon) {
    	
    }

    @Override
    public Iterable<Bonbon> findAll() {
    	
		return null;
    }

    @Override
    public Bonbon findById(final Long id) {
    	
		return null;
    }

    @Override
    public Bonbon save(final Bonbon bonbon) {
    	RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
    	RestClient client = builder.build();
    	Response response = null;
    	Map<String, String> params = Collections.emptyMap();
    	String jsonString = "{" +
    	            "\"id\":\""+bonbon.getId() +"\"," +
    	            "\"nom\":\""+bonbon.getNom() +"\"," +
    	            "\"couleur\":\""+bonbon.getCouleur() +"\"," +
    	            "\"poids\":\""+bonbon.getPoids() +"\"," +
    	            "\"composition\":\""+bonbon.getComposition() +"\""+
    	        "}";
    	HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
    	try {
    		response = client.performRequest("PUT", "/table/bonbon/1", params, entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ObjectMapper mapper = new ObjectMapper();
    	
    	Bonbon res = new Bonbon();
    	try {
			res = mapper.readValue(EntityUtils.toString(response.getEntity()), Bonbon.class);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	close(client);
		return res;
    }

//    @Autowired
//    public void setBookRepository(final BonbonRepository bonbonRepository) {
//    	close();
//    }
    
    private void close( RestClient client) {
    	try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
