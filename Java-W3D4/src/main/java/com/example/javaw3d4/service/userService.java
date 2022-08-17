package com.example.javaw3d4.service;


import com.example.javaw3d4.dto.loginForm;
import com.example.javaw3d4.exception.apiException;
import com.example.javaw3d4.model.User;
import com.example.javaw3d4.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class userService {
    private userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new apiException("Wrong user ID!");
        }
        userRepository.delete(user);
    }

    public User getUserByID(String id) {
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new apiException("Wrong user ID!");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        User user=userRepository.findUserByEmail(email);
        if(user==null){
            throw new apiException("Wrong user email!");
        }
        return user;
    }

    public List<User> getUsersByAge(Integer age) {
        List<User> users=userRepository.findByAgeGreaterThan(age);
        if (users.isEmpty()){
            throw new apiException("There is no users with age grater than this age!");
        }
        return users;
    }

    public Integer countUsersByRole(String role) {
        List<User> users=userRepository.findAllByRole(role);
        return users.size();
    }

    public void checkUser(loginForm user){
        User user1=userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (user1==null){
            throw new apiException("Wrong username or password!");
        }
    }

    public void updateUser(User user, String id) {
        User myUser=userRepository.findUserById(id);

        if(myUser==null){
            throw new apiException("Wrong user ID!");
        }

        if (myUser.getRole().equals("user")){
            throw new apiException("Admin only can update!");
        }

        myUser.setId(user.getId());
        myUser.setUsername(user.getUsername());
        myUser.setPassword(user.getPassword());
        myUser.setEmail(user.getEmail());
        myUser.setRole(user.getRole());
        myUser.setJoiningYear(user.getJoiningYear());
        myUser.setAge(user.getAge());
        userRepository.save(myUser);
    }

    public void updatePass(String id, String newPass){
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new apiException("Wrong user ID!");
        }
        user.setPassword(newPass);
        userRepository.save(user);
    }

    public void checkJoiningYear(String id, LocalDate joiningYear){
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new apiException("Wrong user ID!");
        }
        if (!user.getJoiningYear().isEqual(joiningYear)){
            throw new apiException("Wrong joining year!");
        }
    }

    public List<User> getUsersByJoiningYear(LocalDate joiningYear){
        List<User> users=userRepository.findByJoiningYearAfter(joiningYear);
        if (users.isEmpty()){
            throw new apiException("There are no users joined with this year or after");
        }
        return users;
    }

    public List<User> getUsersByJoiningYearAndAge(LocalDate joiningYear , Integer age){
        List<User> users=userRepository.findByJoiningYearBeforeAndAge(joiningYear,age);
        if (users.isEmpty()){
            throw new apiException("There are no users joined with this year or before and have the same age!");
        }
        return users;
    }
}
