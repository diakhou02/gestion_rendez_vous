package com.rv.repositories;
import com.rv.entities.Medecin;
import com.rv.repositories.bd.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MedecinRepositorie {
    private final Database database;

    public MedecinRepositorie (Database database) {
        this.database = database;
    }

    public void createMedecin(Medecin medecin) {
        try (Connection connection = database.getConnection()) {
            String query = "INSERT INTO medecin (nom, prenom, specialite) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, medecin.getNom());
                preparedStatement.setString(2, medecin.getPrenom());
                preparedStatement.setString(3, medecin.getSpecialite());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Gérer les exceptions SQL
            e.printStackTrace();
        }
    }

    public Medecin getMedecinById(int medecinId) {
        try (Connection connection = database.getConnection()) {
            String query = "SELECT * FROM medecin WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, medecinId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Medecin medecin = new Medecin();
                        medecin.setId(resultSet.getInt("id"));
                        medecin.setNom(resultSet.getString("nom"));
                        medecin.setPrenom(resultSet.getString("prenom"));
                        medecin.setSpecialite(resultSet.getString("specialite"));
                        return medecin;
                    }
                }
            }
        } catch (SQLException e) {
            // Gérer les exceptions SQL
            e.printStackTrace();
        }
        return null;
    }

    public void deleteMedecin(int medecinId) {
        try (Connection connection = database.getConnection()) {
            String query = "DELETE FROM medecin WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, medecinId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Gérer les exceptions SQL
            e.printStackTrace();
        }
    }
}

