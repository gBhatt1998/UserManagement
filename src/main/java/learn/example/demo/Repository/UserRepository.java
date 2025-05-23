package learn.example.demo.Repository;

import learn.example.demo.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {



    Page <User> findUserDetailsByNameStartingWith(char userName,Pageable page);
}
