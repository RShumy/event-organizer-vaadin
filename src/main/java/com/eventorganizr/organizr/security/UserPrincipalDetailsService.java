package com.eventorganizr.organizr.security;

import com.eventorganizr.organizr.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserService userService;

    UserPrincipalDetailsService(UserService userService){
        this.userService = userService;
        System.out.println("From User Details Service :" + System.identityHashCode(userService));
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipalDetails(userService.findUserByUserName(username));
    }

    //Just to test if this gets hashed
    public UserService getUserService() {
        return userService;
    }
}
