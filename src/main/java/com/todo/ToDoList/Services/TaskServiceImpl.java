package com.todo.ToDoList.Services;

import com.todo.ToDoList.Model.Task;
import com.todo.ToDoList.Repository.TaskRepository;
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

    @Override
    public Task modifyTask(Integer id, String text, Boolean completed) {


        Optional<Task> actualTask= taskRepository.findById(id);
        actualTask.get().setText(text);
        actualTask.get().setCompleted(completed);
        taskRepository.save(actualTask.get());

        return actualTask.get();
    }

    @Override
    public Task modifyCompletedStatusTask(Integer id) {
        Optional<Task> actualTask= taskRepository.findById(id);
        boolean status= actualTask.get().getCompleted();
        actualTask.get().setCompleted(!status);
        taskRepository.save(actualTask.get());
        return actualTask.get();

    }

    @Override
    public Optional<Task> deleteTask(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(taskRepository::delete);
        return task;
    }
}
