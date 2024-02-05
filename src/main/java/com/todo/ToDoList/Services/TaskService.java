package com.todo.ToDoList.Services;

import com.todo.ToDoList.Model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Integer id);

    Task createTask(String text,Boolean completed);

    Task modifyTask(Integer id, String text, Boolean completed);

    Optional<Task> deleteTask(Integer id);
}
