package org.eventorganizer.app.service;

import org.eventorganizer.app.entity.Authority;
import org.eventorganizer.app.exception.RecordNotFoundException;
import org.eventorganizer.app.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorityService {

    private final AuthorityRepository authRepository;

    public AuthorityService( AuthorityRepository authRepository ){
        this.authRepository = authRepository;
    }

    public Authority findAuthority( Integer id ){
        Authority auth = authRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        System.out.println("Authority from service has been found: " + auth);
        return auth;
    }

    public List<Authority> getAuthorities( ){
        return authRepository.findAll();
    }

    public void saveAuthority( Authority authority ){
        try { authRepository.save( authority ); }
        catch  ( RuntimeException e ){
            throw new RuntimeException( "Cannot Add Authority!" +
            //remove afterwards
                    Arrays.toString( e.getStackTrace()) );
        }
    }

    public void updateAuthority( Integer id, Authority authority ){
        Authority authToUpdate = findAuthority( id );
        authToUpdate.setName( authority.getName() );
        authRepository.save( authToUpdate );
    }

    public void delete(Authority authority ) {
        try {
            authRepository.delete(authority);
        } catch (RuntimeException e) {
            throw new RuntimeException("Authority either never existed or was deleted!");
        }
    }
}
