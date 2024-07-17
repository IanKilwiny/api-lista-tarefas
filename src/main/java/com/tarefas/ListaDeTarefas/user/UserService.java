package com.tarefas.ListaDeTarefas.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserRequest userRequest){
        User user = new User(userRequest);
        return userRepository.save(user);
    }

    public UserData getInfoUser(UUID id){
        Optional<User> optionalUser = this.userRepository.findById(id);

        return optionalUser
                .stream()
                .map(user->new UserData(user.getName(), user.getEmail())).iterator()
                .next();
    }

    public Optional<User> getUserId(UUID id){
        return this.userRepository.findById(id);
    }


}
