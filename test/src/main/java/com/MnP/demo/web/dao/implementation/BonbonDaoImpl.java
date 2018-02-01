package com.MnP.demo.web.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.log4j.Logger;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;

import com.MnP.demo.web.dao.BonbonDao;
import com.MnP.demo.web.model.Bonbon;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BonbonDaoImpl implements BonbonDao {

    private static Logger LOGGER = Logger.getLogger(BonbonDaoImpl.class);

    @Override
    public void delete(final String id) {
        final HttpHost tab[] = { new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http") };
        final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(tab));
        DeleteRequest request = new DeleteRequest("table", "bonbon",id);
        try {
			client.delete(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                client.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Bonbon> findAll() {
        final HttpHost tab[] = { new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http") };
        final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(tab));
        final SearchRequest searchRequest = new SearchRequest("table");
        final ObjectMapper mapper = new ObjectMapper();

        SearchHits searchHits = null;
        final List<Bonbon> lstBonbon = new ArrayList<Bonbon>();
        searchRequest.types("bonbon");
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (searchResponse != null) {
            searchHits = searchResponse.getHits();
            for (final SearchHit hit : searchHits) {
                try {
                    lstBonbon.add(mapper.readValue(hit.getSourceAsString(), Bonbon.class));
                } catch (JsonParseException | JsonMappingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return lstBonbon;
    }

    @Override
    public Bonbon findById(final String id) {
        final HttpHost tab[] = { new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http") };
        final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(tab));
        final ObjectMapper mapper = new ObjectMapper();

        Bonbon res = null;
        GetResponse responseGet = null;
        final GetRequest getRequest = new GetRequest("table", "bonbon", id);
        try {
            responseGet = client.get(getRequest);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (responseGet.isExists()) {
                res = mapper.readValue(responseGet.getSourceAsString(), Bonbon.class);
            }
        } catch (JsonParseException | JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public void save(final Bonbon bonbon) {
        final HttpHost tab[] = { new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http") };
        final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(tab));
        final String jsonString =
                "{"
                        + "\"id\":\""
                        + bonbon.getId()
                        + "\","
                        + "\"nom\":\""
                        + bonbon.getNom()
                        + "\","
                        + "\"couleur\":\""
                        + bonbon.getCouleur()
                        + "\","
                        + "\"poids\":\""
                        + bonbon.getPoids()
                        + "\","
                        + "\"composition\":\""
                        + bonbon.getComposition()
                        + "\""
                        + "}";

        final IndexRequest request = new IndexRequest("table", "bonbon", bonbon.getId());
        request.source(jsonString, XContentType.JSON);
        try {
            client.index(request);

        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // @Autowired
    // public void setBookRepository(final BonbonRepository bonbonRepository) {
    // close();
    // }

    public void update(final Bonbon bonbon) {
        final HttpHost tab[] = { new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http") };
        final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(tab));
        final UpdateRequest request = new UpdateRequest("table", "bonbon", bonbon.getId());
        final String jsonString =
                "{"
                        + "\"id\":\""
                        + bonbon.getId()
                        + "\","
                        + "\"nom\":\""
                        + bonbon.getNom()
                        + "\","
                        + "\"couleur\":\""
                        + bonbon.getCouleur()
                        + "\","
                        + "\"poids\":\""
                        + bonbon.getPoids()
                        + "\","
                        + "\"composition\":\""
                        + bonbon.getComposition()
                        + "\""
                        + "}";
        request.doc(jsonString, XContentType.JSON);
        try {
            client.update(request);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
