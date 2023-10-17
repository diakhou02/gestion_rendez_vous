package com.rv.entities;

public class Specialite {
    private int id;
    private String specialiteText;

    public Specialite(int id, String specialiteText) {
        this.id = id;
        this.specialiteText = specialiteText;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSpecialiteText() {
        return specialiteText;
    }
    public void setSpecialiteText(String specialiteText) {
        this.specialiteText = specialiteText;
    }

    
}
