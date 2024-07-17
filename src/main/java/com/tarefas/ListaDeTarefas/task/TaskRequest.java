package com.tarefas.ListaDeTarefas.task;

import com.tarefas.ListaDeTarefas.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record TaskRequest(String title, String content, String first_date, String end_date, User user){

}

