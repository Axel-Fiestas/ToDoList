package com.todo.ToDoList.Services;

import com.todo.ToDoList.Dto.CreateTaskDto;
import com.todo.ToDoList.Dto.ModifyTaskDto;
import com.todo.ToDoList.Model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Integer id);

    Task createTask(CreateTaskDto createTaskDto);

    Task modifyTask(Integer id, ModifyTaskDto modifyTaskDto);

    Task modifyCompletedStatusTask(Integer id);

    Optional<Task> deleteTask(Integer id);
}
