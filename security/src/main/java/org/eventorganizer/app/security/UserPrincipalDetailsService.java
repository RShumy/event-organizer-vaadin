package org.eventorganizer.app.security;

import org.eventorganizer.app.entity.User;
import org.eventorganizer.app.exception.RecordNotFoundException;
import org.eventorganizer.app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    UserPrincipalDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
        System.out.println("From User Details Service :" + System.identityHashCode(userRepository));
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws RecordNotFoundException {
        User user = ofNullable(userRepository.findByUserName(username)).get()
                .orElseThrow(RecordNotFoundException::new);
        return new UserPrincipalDetails(user);
    }

}
