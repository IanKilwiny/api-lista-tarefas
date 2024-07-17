package com.tarefas.ListaDeTarefas.task;

import com.tarefas.ListaDeTarefas.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "first_date", nullable = false)
    private LocalDateTime firstDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "user_id") // Define foreign key column
    private User user;

    public Task(TaskRequest taskRequest, User user){
        this.title = taskRequest.title();
        this.content = taskRequest.content();
        this.firstDate = LocalDateTime.parse(taskRequest.first_date(), DateTimeFormatter.ISO_DATE_TIME);
        this.endDate = LocalDateTime.parse(taskRequest.end_date(), DateTimeFormatter.ISO_DATE_TIME);
        this.user = user;
    }

}
