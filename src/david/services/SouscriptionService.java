package david.services;

import david.entities.Souscription;
import java.util.List;

public interface SouscriptionService {
    void addSouscription(Souscription souscription);
    Souscription getSouscriptionById(int id);
    List<Souscription> getAllSouscriptions();
    void updateSouscription(Souscription souscription);
    void deleteSouscription(int id);
}
