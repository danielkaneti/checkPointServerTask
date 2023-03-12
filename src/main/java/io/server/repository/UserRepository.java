package io.server.repository;

import io.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.gpa>90")
    List<User> getAllExcellent();
}
