package com.tarefas.ListaDeTarefas.task;

import com.tarefas.ListaDeTarefas.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //Adicionar task
    public Task addTask(TaskRequest taskRequest, User user){
        Task newTask = new Task(taskRequest, user);
        return taskRepository.save(newTask);
    }

    //Pegar todas as tasks
    public List<TaskData> getAllTask(UUID id){
        List<Task> optionalUser = this.taskRepository.findByUserId(id);
        return optionalUser.stream().map(task -> new TaskData(task.getTitle(), task.getContent(), task.getFirstDate(), task.getEndDate())).toList();
    }
}
