import david.managedbeans.ClientController;
import david.managedbeans.ProduitController;
import david.managedbeans.SmsController;
import david.managedbeans.SouscriptionController;

public class Main {
    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        clientController.ajouterClients();

        ProduitController produitController = new ProduitController();
        produitController.ajouterProduits();

        SouscriptionController souscriptionController = new SouscriptionController();
        souscriptionController.ajouterSouscriptions();

        SmsController smsController = new SmsController();
        smsController.ajouterSms();
    }
}