package david.managedbeans;

import david.entities.Produit;
import david.services.ProduitService;
import david.services.implementations.ProduitServiceImp;

public class ProduitController {
    private final ProduitService produitService;

    public ProduitController() {
        this.produitService = (ProduitService) new ProduitServiceImp();
    }

    public void ajouterProduits() {
        ajouterProduitEpargne();
        ajouterProduitCourant();
    }

    private void ajouterProduitEpargne() {
        Produit produit = new Produit();
        produit.setLibelle("Epargne");
        produit.setActif("O");
        produitService.addProduit(produit);
    }

    private void ajouterProduitCourant() {
        Produit produit = new Produit();
        produit.setLibelle("Courant");
        produit.setActif("N");
        produitService.addProduit(produit);
    }


}
