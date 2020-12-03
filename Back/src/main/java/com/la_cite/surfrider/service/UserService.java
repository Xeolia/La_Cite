package com.la_cite.surfrider.service;

import com.la_cite.surfrider.SecurityConfigurer;
import com.la_cite.surfrider.User;
import com.la_cite.surfrider.repository.UserRepository;
import com.la_cite.surfrider.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfigurer passwordEncoder;

    @Autowired
    private JwtUtil TokenUtil;

    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username)
    {
        return userRepository.getUserByUsername(username);
    }

    public boolean createUser(String username, String password, String name, String email)
    {
        User user = userRepository.getUserByUsername(username);
        if( user !=  null)
        {
            return false;
        }
        else
        {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.passwordEncoder().encode(password));
            newUser.setName(name);
            newUser.setEmail(email);
            userRepository.save(newUser);
            return true;
        }

    }
    public boolean changePassword(String username, String password)
    {
        User user = userRepository.getUserByUsername(username);
        if(user != null)
        {
            userRepository.delete(user);
            user.setPassword(passwordEncoder.passwordEncoder().encode(password));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean changeMail(String username, String mail)
    {
        User user = userRepository.getUserByUsername(username);
        if(user != null)
        {
            userRepository.delete(user);
            user.setEmail(mail);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public String getUsernameFromToken(String token)
    {
        token = token.substring(7);
        return TokenUtil.extractUsername(token);
    }
}
