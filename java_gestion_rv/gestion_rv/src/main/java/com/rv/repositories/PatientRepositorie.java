package com.rv.repositories;
import com.rv.entities.Patient;
import com.rv.repositories.bd.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientRepositorie {
    private final Database database;
    
     public PatientRepositorie(Database database) {
        this.database = database;
    }

    public void createPatient(Patient patient) {
        try (Connection connection = database.getConnection()) {
            String query = "INSERT INTO patient (nom, prenom) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, patient.getNom());
                preparedStatement.setString(2, patient.getPrenom());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Patient getPatientById(int patientId) {
        try (Connection connection = database.getConnection()) {
            String query = "SELECT * FROM patient WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Patient patient = new Patient();
                        patient.setId(resultSet.getInt("id"));
                        patient.setNom(resultSet.getString("nom"));
                        patient.setPrenom(resultSet.getString("prenom"));
                        return patient;
                    }
                }
            }
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        return null;
    }

    public void deletePatient(int patientId) {
        try (Connection connection = database.getConnection()) {
            String query = "DELETE FROM patient WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


