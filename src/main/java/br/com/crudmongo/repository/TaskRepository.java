package br.com.crudmongo.repository;

import br.com.crudmongo.model.Task;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final MongoCollection<Document> collection;

    public TaskRepository(MongoDatabase database) {
        this.collection = database.getCollection("tasks");
    }

    public void saveTask(Task task) {
        Document doc = new Document("titulo", task.getTitle())
                .append("descricao", task.getDescription())
                .append("concluida", task.isStatus());

        collection.insertOne(doc);
        System.out.println("Tarefa criada!");
    }

    public List<Task> listarTarefas() {
        List<Task> lista = new ArrayList<>();
        for (Document doc : collection.find()) {
            lista.add(new Task(
                    doc.getString("titulo"),
                    doc.getString("descricao"),
                    doc.getBoolean("concluida")
            ));
        }
        return lista;
    }

    public void updateTask(ObjectId id, boolean status) {
        collection.updateOne(Filters.eq("_id", id), new Document("$set",  new Document("status", status)));
        System.out.println("Task updated!");
    }

    public void deleteTask(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
        System.out.println("Task deleted!");
    }
}
