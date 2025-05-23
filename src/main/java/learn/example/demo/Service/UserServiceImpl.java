package learn.example.demo.Service;

import learn.example.demo.Model.User;
import learn.example.demo.Repository.UserRepo;
import learn.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private UserRepository userRepository;

//
//    public User CreatUser(User u){
//        return userRepository.save(u);
//    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    public User getUserByID(long id){
        Optional<User> optionalUser= userRepository.findById(id);
        return optionalUser.get();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deletUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {

        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

}
