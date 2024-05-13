package david.managedbeans;

import david.entities.Client;
import david.entities.Produit;
import david.entities.Sms;
import david.services.ClientService;
import david.services.ProduitService;
import david.services.SmsService;
import david.services.implementations.ClientServiceImp;
import david.services.implementations.ProduitServiceImp;
import david.services.implementations.SmsServiceImp;

public class SmsController {
    private final SmsService smsService;
    private final ProduitService produitService;
    private final ClientService clientService;

    public SmsController() {
        this.smsService = new SmsServiceImp();
        this.produitService = new ProduitServiceImp();
        this.clientService = new ClientServiceImp();
    }


    public void ajouterSms() {
        Sms sms1 = new Sms();
        sms1.setIdClient(1); // ID du client choisi
        sms1.setLibelle(getMessageSouscription(1, 1)); // 1 pour ID client et 1 pour ID produit
        smsService.addSms(sms1);

        Sms sms2 = new Sms();
        sms2.setIdClient(2); // ID du client choisi
        sms2.setLibelle(getMessageSouscription(2, 2)); // 2 pour ID client et 2 pour ID produit
        smsService.addSms(sms2);
    }

    private String getMessageSouscription(int idClient, int idProduit) {
        Client client = clientService.getClientById(idClient);
        Produit produit = produitService.getProduitById(idProduit);

        if (client != null && produit != null) {
            return "Merci " + client.getPrenom() + " " + client.getNom() + " pour votre souscription au produit " + produit.getLibelle() + ".";
        }

        return "Message de souscription inconnu";
    }
}
