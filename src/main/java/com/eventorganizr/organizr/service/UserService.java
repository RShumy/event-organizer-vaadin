package com.eventorganizr.organizr.service;

import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.exception.RecordNotFoundException;
import com.eventorganizr.organizr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Long id) {
       return userRepository.findById(id).
               orElseThrow(RecordNotFoundException::new);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        try { userRepository.save(user); }
        catch (RuntimeException e){
            throw new RuntimeException("Cannot create user with an existing email!");
        }
    }

    public void updateUser(Long id, User user){
        User userToUpdate = userRepository.findById(id).
                orElseThrow(RecordNotFoundException::new);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());

        userRepository.save(userToUpdate);
    }

    public void delete(Long id){
        boolean existsById = userRepository.existsById(id);
        if (!existsById) throw new RecordNotFoundException();
        userRepository.deleteById(id);
    }
}
