package br.com.crudmongo.model;

import org.bson.types.ObjectId;

public class Task {
    private ObjectId id;
    private String title;
    private String description;
    private boolean status;

    public Task(String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", titulo='" + title + '\'' +
                ", descricao='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
