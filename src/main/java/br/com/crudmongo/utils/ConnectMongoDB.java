package br.com.crudmongo.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
    private static final String URI = "";
    private static final String DATABASE_NAME = "Cluster0";

    public static MongoDatabase conectar() {
        MongoClient cliente = MongoClients.create(URI);
        return cliente.getDatabase(DATABASE_NAME);
    }

}

