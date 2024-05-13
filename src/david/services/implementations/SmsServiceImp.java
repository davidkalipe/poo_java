package david.services.implementations;

import david.services.SmsService;
import david.entities.Sms;
import david.utils.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmsServiceImp implements SmsService {
    @Override
    public void addSms(Sms sms) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Sms (idClient, libelle) VALUES (?, ?)")) {
            preparedStatement.setInt(1, sms.getIdClient());
            preparedStatement.setString(2, sms.getLibelle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sms getSmsById(int id) {
        Sms sms = null;
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Sms WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sms = new Sms();
                sms.setId(resultSet.getInt("id"));
                sms.setIdClient(resultSet.getInt("idClient"));
                sms.setLibelle(resultSet.getString("libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sms;
    }

    @Override
    public List<Sms> getAllSms() {
        List<Sms> smsList = new ArrayList<>();
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Sms")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sms sms = new Sms();
                sms.setId(resultSet.getInt("id"));
                sms.setIdClient(resultSet.getInt("idClient"));
                sms.setLibelle(resultSet.getString("libelle"));
                smsList.add(sms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smsList;
    }

    @Override
    public void updateSms(Sms sms) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Sms SET idClient = ?, libelle = ? WHERE id = ?")) {
            preparedStatement.setInt(1, sms.getIdClient());
            preparedStatement.setString(2, sms.getLibelle());
            preparedStatement.setInt(3, sms.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSms(int id) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Sms WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
