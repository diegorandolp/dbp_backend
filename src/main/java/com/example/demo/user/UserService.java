package com.example.demo.user;

import com.example.demo.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.round;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /* POST- ya hay un createUser en AutenticationService */
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username);
            }
        };
    }

    // GET BY ID
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return mapper.userToUserResponseDto(user);
    }
    // GET ALL
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return mapper.userResponseDtoList(users);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void userToUserWinner(User user, double ganancia) {
        User userWinner = user;
        Long newPoints = round(ganancia);
        userWinner.setPoints(newPoints);

        userRepository.save(userWinner);
        return;
    }

    public void userToUserLose(User user, double perdida) {
        User userLoser = user;
        Long newPoints = round(perdida);
        userLoser.setPoints(newPoints);

        userRepository.save(userLoser);
        return;
    }
    public UserResponseDto getCurrentUser(Authentication authentication){
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }

        String username = authentication.getName();

        User currentUser = userRepository.findByUsername(username);
        return mapper.userToUserResponseDto(currentUser);

    }
}
