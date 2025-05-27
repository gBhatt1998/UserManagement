package learn.example.demo.Repository;

import learn.example.demo.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepo {

    UserRepo(){
//        createUser();
    }

    private List<User> userList=new ArrayList<User>();

//    public  void createUser(){
//        List<User> newUser= List.of(
//                new User(1L,"john","football","john@123",25),
//                new User(2L,"josh","basketball","joshgmail@123",26),
//                new User(3L,"steve","chess","steve@123",20)
//        );
//        userList.addAll(newUser);
//    }
//
//    public List<User> getUserList(){
//
//        return userList;
//    }
//
//    public User getUserById(int id) {
//        return userList.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst()
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found"));
//    }
//
//    public User save(User u) {
//        userList.add(u);
//        return u;
//    }
//
//    public int delete(int id) {
//        User userToDelete = getUserById(id);
//        userList.remove(userToDelete);
//        return id;
//    }
//
//    public User update(int id, User updatedUser) {
//
//        User existingUser = getUserById(id);
//
//
//        existingUser.setName(updatedUser.getName());
//        existingUser.setHobby(updatedUser.getHobby());
//        existingUser.setEmail(updatedUser.getEmail());
//        existingUser.setAge(updatedUser.getAge());
//
//        return existingUser;
//    }

}
