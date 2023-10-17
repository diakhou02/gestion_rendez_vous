package com.rv.repositories;
import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.Rv;
import com.rv.repositories.bd.Database;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RvRepositorie {

    private final Database database;

    public RvRepositorie (Database database) {
        this.database = database;
    }

    public void planifierRendezVous(Rv rendezVous) {
        try (Connection connection = database.getConnection()) {
            String query = "INSERT INTO rendez_vous (patient_id, medecin_id, date, heure) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, rendezVous.getPatient().getId());
                preparedStatement.setInt(2, rendezVous.getMedecin().getId());
                preparedStatement.setDate(3, Date.valueOf(rendezVous.getDate()));
                preparedStatement.setTime(4, Time.valueOf(rendezVous.getHeure()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rv> getRendezVousDuJour() {
        List<Rv> rendezVousList = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            LocalDate today = LocalDate.now();
            String query = "SELECT * FROM rendez_vous WHERE date = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, Date.valueOf(today));
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Rv rendezVous = mapResultSetToRendezVous(resultSet);
                        rendezVousList.add(rendezVous);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendezVousList;
    }

    // Ajoutez d'autres méthodes pour la gestion des rendez-vous, par exemple, annuler un rendez-vous, afficher les rendez-vous d'un médecin, etc.

    private Rv mapResultSetToRendezVous(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int patientId = resultSet.getInt("patient_id");
        int medecinId = resultSet.getInt("medecin_id");
        LocalDate date = resultSet.getDate("date").toLocalDate();
        LocalTime heure = resultSet.getTime("heure").toLocalTime();

        Patient patient = getPatientById(patientId);
        Medecin medecin = getMedecinById(medecinId);

        return new Rv(id, patient, medecin, date, heure);
    }

    private Patient getPatientById(int patientId) {
        return null;
    }

    private Medecin getMedecinById(int medecinId) {
        return null;
    }
}
