package br.com.crudmongo;

import br.com.crudmongo.model.Task;
import br.com.crudmongo.repository.TaskRepository;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (MongoClient cliente = MongoClients.create("mongodb+srv://kaikemanuel39:658926250821@cluster0.mbrdi.mongodb.net/")) {
            MongoDatabase banco = cliente.getDatabase("Cluster0");
            TaskRepository repositorio = new TaskRepository(banco);

            // Criar uma nova tarefa
//            Task tarefa1 = new Task("Estudar MongoDB", "Aprender CRUD com Java", false);
//            repositorio.saveTask(tarefa1);

            // Listar tarefas
            List<Task> tarefas = repositorio.listarTarefas();

            // Atualizar uma tarefa (marcar como concluída)
            if (!tarefas.isEmpty()) {
                ObjectId id = tarefas.get(0).getId(); // Pegando o primeiro ID (ajuste conforme necessário)
                repositorio.updateTask(id, true);
            }

            System.out.println("Tarefas cadastradas:");
            tarefas.forEach(System.out::println);
//
//            // Deletar uma tarefa
            if (!tarefas.isEmpty()) {
                ObjectId id = tarefas.get(0).getId();
                repositorio.deleteTask(id);
            }

            System.out.println("Tarefas cadastradas:");
            tarefas.forEach(System.out::println);
        }
    }
}
