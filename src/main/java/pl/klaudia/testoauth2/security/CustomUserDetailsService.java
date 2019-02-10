package pl.klaudia.testoauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.klaudia.testoauth2.model.AUser;
import pl.klaudia.testoauth2.repository.UsersRepository;


import javax.transaction.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people username with either username or email
        AUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }


        /*return new userPrincipal(user.getUsername(), user.getPassword(),true,true,true,true, emptyList());*/
        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        AUser user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        //return new User( user.getUsername(),user.getPassword(),true,true,true,true, emptyList() );
        return UserPrincipal.create(user);
    }
}
