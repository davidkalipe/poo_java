package david.entities;

public class Sms {
    private int id;
    private int idClient;
    private String libelle;

    public Sms(int id, int idClient, String libelle) {
        this.id = id;
        this.idClient = idClient;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Sms() {
    }


}
