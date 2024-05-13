package david.managedbeans;
import david.services.ClientService;
import david.services.implementations.ClientServiceImp;
import david.entities.Client;

public class ClientController {
    private final ClientService clientService;

    public ClientController() {
        this.clientService = new ClientServiceImp();
    }

    public void ajouterClients() {
        ajouterClient1();
        ajouterClient2();
        ajouterClient3();
        ajouterClient4();
    }

    private void ajouterClient1() {
        Client client = new Client();
        client.setNom("DADJU");
        client.setPrenom("Wanda");
        client.setTelephone("90345666");
        clientService.addClient(client);
    }

    private void ajouterClient2() {
        Client client = new Client();
        client.setNom("TAYC");
        client.setPrenom("Salamandre");
        client.setTelephone("94355678");
        clientService.addClient(client);
    }

    private void ajouterClient3() {
        Client client = new Client();
        client.setNom("SLIMANE");
        client.setPrenom("Twilight");
        client.setTelephone("+228 93454334");
        clientService.addClient(client);
    }

    private void ajouterClient4() {
        Client client = new Client();
        client.setNom("Nom4");
        client.setPrenom("Prenom4");
        client.setTelephone("444444444");
        clientService.addClient(client);
    }

}
