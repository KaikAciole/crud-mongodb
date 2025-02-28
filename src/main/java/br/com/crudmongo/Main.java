package br.com.crudmongo;

import br.com.crudmongo.model.Task;
import br.com.crudmongo.repository.TaskRepository;
import br.com.crudmongo.utils.ConnectMongoDB;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository(ConnectMongoDB.conectar());

        // Criando tarefas
        Task t1 = new Task("Aprender MongoDB", "Estudar a documentação do MongoDB", false);
        Task t2 = new Task("Implementar CRUD", "Criar um sistema de tarefas usando MongoDB", false);
        repo.saveTask(t1);
        repo.saveTask(t2);

        // Listando todas as tarefas
        System.out.println("Lista de tarefas:");
        repo.listTasks().forEach(System.out::println);

        // Buscar uma tarefa pelo ID
        Task tarefa = repo.findById(new ObjectId("67c2079a8f30dc72d1765d96"));
        if (tarefa != null) {
            System.out.println("Tarefa encontrada: " + tarefa);
        } else {
            System.out.println("Tarefa não encontrada!");
        }

        // Atualizar status de uma tarefa
        if (tarefa != null) {
            repo.updateTask(tarefa.getId(), true);
        }

        // Listar novamente após atualização
        System.out.println("Lista após atualização:");
        repo.listTasks().forEach(System.out::println);

        // Excluir uma tarefa (com um ID válido)
        if (tarefa != null) {
            repo.deleteTask(tarefa.getId());
        }

        // Listar após exclusão
        System.out.println("Lista final:");
        repo.listTasks().forEach(System.out::println);
    }
}
