package com.tarefas.ListaDeTarefas.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    //pega os dados da chave estrangeira
    public List<Task> findByUserId(UUID id);
}
