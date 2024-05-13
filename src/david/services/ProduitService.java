package david.services;

import david.entities.Produit;
import java.util.List;

public interface ProduitService {
    void addProduit(Produit produit);
    Produit getProduitById(int id);
    List<Produit> getAllProduits();
    void updateProduit(Produit produit);
    void deleteProduit(int id);
}
