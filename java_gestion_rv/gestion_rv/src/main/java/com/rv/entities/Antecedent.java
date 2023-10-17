package com.rv.entities;

public class Antecedent {
    private int id;
    private String antecedentText;

    public Antecedent(int id, String antecedentText) {
        this.id = id;
        this.antecedentText = antecedentText;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAntecedentText() {
        return antecedentText;
    }
    public void setAntecedentText(String antecedentText) {
        this.antecedentText = antecedentText;
    }


}
