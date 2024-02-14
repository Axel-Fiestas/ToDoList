package com.todo.ToDoList.Controller;

import com.todo.ToDoList.Dto.CreateTaskDto;
import com.todo.ToDoList.Dto.ModifyTaskDto;
import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("api/")
public class TaskController {

    final
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Transactional(readOnly = true)
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @Transactional(readOnly = true)
    @GetMapping("/tasks/{id}")
    public Optional<Task> taskById(@PathVariable int id){
        return taskService.getTaskById(id);
    }

    @PostMapping("tasks")
    public Task createNewTask(@RequestBody CreateTaskDto createTaskDto){
        return taskService.createTask(createTaskDto);
    }

    @Transactional()
    @PutMapping("tasks/{id}")
    public Task modifyTask(@PathVariable int id, @RequestBody ModifyTaskDto modifyTaskDto){
        return taskService.modifyTask(id,modifyTaskDto);
    }

    @Transactional()
    @PutMapping("tasks/status/{id}")
    public Task modifyCompletedStatusTask(@PathVariable int id){
        return taskService.modifyCompletedStatusTask(id);
    }
    @Transactional()
    @DeleteMapping("tasks/delete/{id}")
    public Optional<Task> deleteTask(@PathVariable int id){
        return taskService.deleteTask(id);
    }



}
