package com.todo.ToDoList.Initializer;

import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    final
    TaskRepository taskRepository;

    public DatabaseInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args){
        taskRepository.save(
                new Task(1,
                        "Learn GraphQL",
                        true)
        );

        System.out.println("Database initialized!");
    }
}
