package com.rv.entities;

import java.util.List;

public class Patient extends Personne {
    private List<Antecedent> antecedents;


    public Patient(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }

    public Patient(int id, String nom, String prenom, List<Antecedent> antecedents) {
        super(id, nom, prenom);
        this.antecedents = antecedents;
    }

    public List<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }
}