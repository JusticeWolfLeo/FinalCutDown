package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.Repository.UserRepository;
import com.example.SpringBootDemo.model.Role;
import com.example.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Transactional
    public void save(User user) {
        repo.save(user);
    }
    @Transactional
    public List<User> listAll() {
        return repo.findAll();
    }
    @Transactional
    public User get(long id) {
        return repo.findById(id).get();
    }
    @Transactional
    public void delete(long id) {
        repo.deleteById(id);
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

    public User findByEmail(String email){
        return repo.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
