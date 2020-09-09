package pl.damianrowinski.flat_manager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.damianrowinski.flat_manager.user.User;
import pl.damianrowinski.flat_manager.user.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userLogin) {
        User user = userService.findByUserLogin(userLogin);
        if (user == null) {
            throw new UsernameNotFoundException(userLogin);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole().getName());
        grantedAuthorities.add(simpleGrantedAuthority);
        return new ApplicationUser(user.getLogin(), user.getPassword(),
                grantedAuthorities, user);
    }
}