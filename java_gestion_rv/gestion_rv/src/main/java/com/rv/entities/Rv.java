package com.rv.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rv {

    private int id;
    private Patient patient;
    private Medecin medecin;
    private LocalDate date;
    private LocalTime heure;

    public Rv(Patient patient, Medecin medecin, LocalDate date, LocalTime heure) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.heure = heure;
    }

    public Rv(int id, Patient patient, Medecin medecin, LocalDate date, LocalTime heure) {
        this.id = id;
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.heure = heure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "id=" + id +
                ", patient=" + patient +
                ", medecin=" + medecin +
                ", date=" + date +
                ", heure=" + heure +
                '}';
    }
}

