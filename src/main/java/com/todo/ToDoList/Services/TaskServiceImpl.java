package com.todo.ToDoList.Services;

import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    final
    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(String text, Boolean completed) {

        Task newTask= Task.builder()
                .text(text)
                .completed(completed)
                .build();
        return taskRepository.save(newTask);
    }
}
