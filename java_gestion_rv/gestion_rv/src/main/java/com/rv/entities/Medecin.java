package com.rv.entities;

import java.util.List;

public class Medecin extends Personne {
    private List<Specialite> specialites;

    public List<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Specialite> specialites) {
        this.specialites = specialites;
    }
}
