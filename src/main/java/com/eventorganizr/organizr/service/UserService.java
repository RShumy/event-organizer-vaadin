package com.eventorganizr.organizr.service;

import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.exception.RecordNotFoundException;
import com.eventorganizr.organizr.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }

    public User findUser(Long id) {
       return userRepository.findById(id)
               .orElseThrow(RecordNotFoundException::new);
    }

    public User findUserByUserName(String userName){
        return userRepository.findByUserName(userName)
                .orElseThrow(RecordNotFoundException::new);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        //Removed Password field from updateUser method to prevent perpetual re-encoding when save user is called
        //Password is saved only at registration if the UserName is not found in the Data Base
        System.out.println("Save User called from User Service");
        try { userRepository.save(user); }
        catch (RuntimeException e){
            throw new RuntimeException("Cannot create user with an existing email!");
        }

    }


    public void updatePassword(User user){
        User userToUpdate = findUser(user.getUserId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        saveUser(user);
    }

    public void updateUser(Long id, User user){
        User userToUpdate = userRepository.findById(id).
                orElseThrow(RecordNotFoundException::new);
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());

        userRepository.save(userToUpdate);
    }

    public void delete(Long id){
        boolean existsById = userRepository.existsById(id);
        if (!existsById) throw new RecordNotFoundException();
        userRepository.deleteById(id);
    }

}
