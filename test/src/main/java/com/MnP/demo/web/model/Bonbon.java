package com.MnP.demo.web.model;

public class Bonbon {

    private Long id;
    private String nom;
    private String couleur;
    private Double poids;
    private String composition;

    public Bonbon() {
        super();
    }

    public Bonbon(final Long id, final String nom, final String couleur, final Double poids, final String composition) {
        super();
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
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
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
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
     * @param couleur
     *            the couleur to set
     */
    public void setCouleur(final String couleur) {
        this.couleur = couleur;
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
                + ", couleur="
                + couleur
                + ", poids="
                + poids
                + ", composition="
                + composition
                + "]";
    }

}
