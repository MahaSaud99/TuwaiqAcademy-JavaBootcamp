package com.example.javaw3d4.repository;

import com.example.javaw3d4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface userRepository extends JpaRepository<User,String> {
    User findUserById(String id);
    User findUserByEmail(String email);
    List<User> findByAgeGreaterThan(Integer age);
    List<User> findAllByRole(String role);
    User findUserByUsernameAndPassword(String username,String password);
    List<User> findByJoiningYearAfter(LocalDate joiningYear);

   List<User> findByJoiningYearBeforeAndAge(LocalDate joiningYear , Integer age);


    User findUserByUsername(String username);
}
