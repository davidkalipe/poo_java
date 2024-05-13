package david.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import david.utils.Connexion;
import david.entities.Client;
import david.services.ClientService;

public class ClientServiceImp implements ClientService {
    public void addClient(Client client) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Client (nom, prenom, telephone) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3, client.getTelephone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setTelephone(resultSet.getString("telephone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }


    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setTelephone(resultSet.getString("telephone"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void updateClient(Client client) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Client SET nom = ?, prenom = ?, telephone = ? WHERE id = ?")) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3, client.getTelephone());
            preparedStatement.setInt(4, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int id) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Client WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
