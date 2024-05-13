package david.services.implementations;

import david.services.SouscriptionService;
import david.utils.Connexion;
import david.entities.Souscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SouscriptionServiceImp implements SouscriptionService {
    @Override
    public void addSouscription(Souscription souscription) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Souscription (dateHeureSous, actif, idClient, idProduit) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(souscription.getDateHeureSous().getTime()));
            preparedStatement.setString(2, souscription.getActif());
            preparedStatement.setInt(3, souscription.getIdClient());
            preparedStatement.setInt(4, souscription.getIdProduit());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Souscription getSouscriptionById(int id) {
        Souscription souscription = null;
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Souscription WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                souscription = new Souscription();
                souscription.setId(resultSet.getInt("id"));
                souscription.setDateHeureSous(resultSet.getTimestamp("dateHeureSous"));
                souscription.setActif(resultSet.getString("actif"));
                souscription.setIdClient(resultSet.getInt("idClient"));
                souscription.setIdProduit(resultSet.getInt("idProduit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souscription;
    }

    @Override
    public List<Souscription> getAllSouscriptions() {
        List<Souscription> souscriptions = new ArrayList<>();
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Souscription")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Souscription souscription = new Souscription();
                souscription.setId(resultSet.getInt("id"));
                souscription.setDateHeureSous(resultSet.getTimestamp("dateHeureSous"));
                souscription.setActif(resultSet.getString("actif"));
                souscription.setIdClient(resultSet.getInt("idClient"));
                souscription.setIdProduit(resultSet.getInt("idProduit"));
                souscriptions.add(souscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souscriptions;
    }

    @Override
    public void updateSouscription(Souscription souscription) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Souscription SET dateHeureSous = ?, actif = ?, idClient = ?, idProduit = ? WHERE id = ?")) {
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(souscription.getDateHeureSous().getTime()));
            preparedStatement.setString(2, souscription.getActif());
            preparedStatement.setInt(3, souscription.getIdClient());
            preparedStatement.setInt(4, souscription.getIdProduit());
            preparedStatement.setInt(5, souscription.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSouscription(int id) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Souscription WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
