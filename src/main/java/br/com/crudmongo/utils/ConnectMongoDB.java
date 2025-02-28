package br.com.crudmongo.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
    private static final String URI = "mongodb+srv://kaikemanuel39:658926250821@cluster0.mbrdi.mongodb.net/";
    private static final String NAME_DB = "Cluster0";

    public static void getConnection() {

        try(MongoClient cliente = MongoClients.create(URI)) {
            MongoDatabase banco = cliente.getDatabase(NAME_DB);
            System.out.println("Conectado ao banco: " + banco.getName());
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }

}
