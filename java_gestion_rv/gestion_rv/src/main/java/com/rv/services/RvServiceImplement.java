package com.rv.services;

import repositories.db.Database;

public class RvServiceImplement implements RvService {
    private Database database;

    public RvServiceImplement(Database database) {
        this.database = database;
    }

    
}
