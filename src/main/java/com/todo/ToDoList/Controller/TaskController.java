package com.todo.ToDoList.Controller;

import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @QueryMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @QueryMapping
    public Optional<Task> taskById(@Argument int id){
        return taskService.getTaskById(id);
    }

/*    @MutationMapping
    public Task createNewTask(@Argument String text, @Argument boolean completed){
        return Task.createTask(text,completed);
    }*/
}
