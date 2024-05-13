package david.entities;

import java.util.Date;

public class Souscription {
    private int id;
    private Date dateHeureSous;
    private String actif;
    private int idClient;
    private int idProduit;

    public Souscription(int id, Date dateHeureSous, String actif, int idClient, int idProduit) {
        this.id = id;
        this.dateHeureSous = dateHeureSous;
        this.actif = actif;
        this.idClient = idClient;
        this.idProduit = idProduit;
    }

    public Souscription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateHeureSous() {
        return dateHeureSous;
    }

    public void setDateHeureSous(Date dateHeureSous) {
        this.dateHeureSous = dateHeureSous;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }


}
