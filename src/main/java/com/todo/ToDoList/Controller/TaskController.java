package com.todo.ToDoList.Controller;

import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    final
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @QueryMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @QueryMapping
    public Optional<Task> taskById(@Argument int id){
        return taskService.getTaskById(id);
    }

    @MutationMapping
    public Task createNewTask(@Argument String text,@Argument boolean completed){
        return taskService.createTask(text,completed);
    }

    @MutationMapping
    public Task modifyTask(@Argument int id, @Argument String text, @Argument boolean completed){
        return taskService.modifyTask(id,text,completed);
    }

    @MutationMapping
    public Task modifyCompletedStatusTask(@Argument int id){
        return taskService.modifyCompletedStatusTask(id);
    }

    @MutationMapping
    public Optional<Task> deleteTask(@Argument int id){
        return taskService.deleteTask(id);
    }



}
