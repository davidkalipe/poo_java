package david.managedbeans;

import david.entities.Souscription;
import david.services.SouscriptionService;
import david.services.implementations.SouscriptionServiceImp;

import java.util.Date;

public class SouscriptionController {
    private final SouscriptionService souscriptionService;

    public SouscriptionController() {
        this.souscriptionService = new SouscriptionServiceImp();
    }

    public void ajouterSouscriptions() {
        ajouterSouscriptionClient1();
        ajouterSouscriptionClient2();
    }

    private void ajouterSouscriptionClient1() {
        Souscription souscription = new Souscription();
        souscription.setDateHeureSous(new Date());
        souscription.setActif("O");
        souscription.setIdClient(1); // ID du premier client choisi
        souscription.setIdProduit(1); // ID du produit Epargne
        souscriptionService.addSouscription(souscription);
    }

    private void ajouterSouscriptionClient2() {
        Souscription souscription = new Souscription();
        souscription.setDateHeureSous(new Date());
        souscription.setActif("O");
        souscription.setIdClient(2); // ID du deuxième client choisi
        souscription.setIdProduit(2); // ID du produit Courant
        souscriptionService.addSouscription(souscription);
    }

}
