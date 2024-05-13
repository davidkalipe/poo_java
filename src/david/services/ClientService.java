package david.services;
import david.entities.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    Client getClientById(int id);
    List<Client> getAllClients();
    void updateClient(Client client);
    void deleteClient(int id);
}
