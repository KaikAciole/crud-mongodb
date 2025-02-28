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
        Document doc = task.toDocument();
        collection.insertOne(doc);
        System.out.println("Tarefa criada!");
    }

    public List<Task> listTasks() {
        List<Task> lista = new ArrayList<>();
        for (Document doc : collection.find()) {
            lista.add(new Task(
                    doc.getObjectId("_id"),
                    doc.getString("title"),
                    doc.getString("description"),
                    doc.getBoolean("concluida")
            ));
        }
        return lista;
    }

    public Task findById(ObjectId id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();
        return (doc != null) ? new Task(
                doc.getObjectId("_id"),
                doc.getString("title"),
                doc.getString("description"),
                doc.getBoolean("concluida")
        ) : null;
    }

    public void updateTask(ObjectId id, boolean status) {
        collection.updateOne(Filters.eq("_id", id),
                new Document("$set", new Document("concluida", status)));
        System.out.println("Tarefa atualizada!");
    }

    public void deleteTask(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
        System.out.println("Tarefa excluída!");
    }
}
