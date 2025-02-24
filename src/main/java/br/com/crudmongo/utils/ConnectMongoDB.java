package br.com.crudmongo.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {

    public static void getConnection(String uri, String nameDB) {

        try(MongoClient cliente = MongoClients.create(uri)) {
            MongoDatabase banco = cliente.getDatabase(nameDB);
            System.out.println("Conectado ao banco: " + banco.getName());
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }

}
