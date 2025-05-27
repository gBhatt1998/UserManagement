package learn.example.demo.Repository;

import learn.example.demo.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository  extends JpaRepository<User,Long> {



    Page <User> findUserDetailsByNameStartingWith(char userName,Pageable page);


    @Query("select u from User u join fetch u.address where u.id = :id")
    User findUserWithAddressById(Long id);

}
