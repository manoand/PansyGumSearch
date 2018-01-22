package com.MnP.demo.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "manoand", type = "bonbons")
public class Bonbon {

    @Id
    private Long id;
    private String nom;
    private String origine;
    private Double poids;
    private String composition;

    public Bonbon() {
        super();
    }

    public Bonbon(final Long id, final String nom, final String origine, final Double poids, final String composition) {
        super();
        this.id = id;
        this.nom = nom;
        this.origine = origine;
        this.poids = poids;
        this.composition = composition;
    }

    /**
     * @return the composition
     */
    public String getComposition() {
        return composition;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the origine
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * @return the poids
     */
    public Double getPoids() {
        return poids;
    }

    /**
     * @param composition
     *            the composition to set
     */
    public void setComposition(final String composition) {
        this.composition = composition;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @param nom
     *            the nom to set
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * @param origine
     *            the origine to set
     */
    public void setOrigine(final String origine) {
        this.origine = origine;
    }

    /**
     * @param poids
     *            the poids to set
     */
    public void setPoids(final Double poids) {
        this.poids = poids;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Bonbon [id="
                + id
                + ", nom="
                + nom
                + ", origine="
                + origine
                + ", poids="
                + poids
                + ", composition="
                + composition
                + "]";
    }

}
