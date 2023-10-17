package com.rv.services;

import repositories.db.Database;

public class PersonneServiceImplement implements PersonneService {
    private Database database;

    public PersonneServiceImplement(Database database) {
        this.database = database;
    }

    // Implémentation des méthodes pour la gestion des personnes
}
