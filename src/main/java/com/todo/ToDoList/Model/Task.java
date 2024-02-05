package com.todo.ToDoList.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Task")
public class Task{
    @Id
    @GeneratedValue
    Integer id;
    @Column(name = "text")
    String text;
    @Column(name = "completed")
    Boolean completed;
}
/*
public record Task(int id, String text, boolean completed) {

    public static List<Task> tasks=Arrays.asList(
            new Task(1,"Play Honkai Star Rail",true),
            new Task(2,"Learn GraphQL with SpringBoot",false),
            new Task(3,"Perrolol",false)
    );

    public static Task getById(int id){
        return tasks.stream()
                .filter(task -> task.id==id)
                .findFirst()
                .orElse(null);
    }

    public static Task createTask(String text,boolean completed){

        Task newTask= new Task(tasks.size()+1,text,completed);

        try{
            List<Task> newList= new ArrayList<Task>(tasks);
            newList.add(newTask);
            tasks=newList;
        }catch (Exception e){
            System.out.println(e);
        }

        return newTask;
    }
}
*/
