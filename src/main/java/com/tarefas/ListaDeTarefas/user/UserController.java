package com.tarefas.ListaDeTarefas.user;

import com.tarefas.ListaDeTarefas.task.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    //Controlller User
    @PostMapping
    public ResponseEntity<User> setUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.addUser(userRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUser(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.getInfoUser(id));
    }


    //Controller Task
    @PostMapping("/task/{id}")
    public ResponseEntity<Task> setTask(@RequestBody TaskRequest taskRequest, @PathVariable UUID id){
        Optional<User> optionalUser = this.userService.getUserId(id);

        return optionalUser.map(user -> ResponseEntity.ok(this.taskService.addTask(taskRequest, user))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<List<TaskData>> getAllTasks(@PathVariable UUID id){
        return ResponseEntity.ok(this.taskService.getAllTask(id));

    }


}
