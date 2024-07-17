package com.tarefas.ListaDeTarefas.task;

import java.time.LocalDateTime;

//Responder com todos os dados necessários
public record TaskData(String title, String content, LocalDateTime first_date, LocalDateTime end_date) {
}
