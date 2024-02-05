package com.todo.ToDoList.Services;

import com.todo.ToDoList.Model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Integer id);
}
