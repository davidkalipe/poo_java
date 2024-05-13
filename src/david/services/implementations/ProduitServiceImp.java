package david.services.implementations;

import david.services.ProduitService;
import david.entities.Produit;
import david.utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitServiceImp implements ProduitService {
    public void addProduit(Produit produit) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Produit (libelle, actif) VALUES (?, ?)")) {
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setString(2, produit.getActif());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Produit getProduitById(int id) {
        Produit produit = null;
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Produit WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                produit = new Produit();
                produit.setId(resultSet.getInt("id"));
                produit.setLibelle(resultSet.getString("libelle"));
                produit.setActif(resultSet.getString("actif"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Produit")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produit produit = new Produit();
                produit.setId(resultSet.getInt("id"));
                produit.setLibelle(resultSet.getString("libelle"));
                produit.setActif(resultSet.getString("actif"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public void updateProduit(Produit produit) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Produit SET libelle = ?, actif = ? WHERE id = ?")) {
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setString(2, produit.getActif());
            preparedStatement.setInt(3, produit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduit(int id) {
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Produit WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
