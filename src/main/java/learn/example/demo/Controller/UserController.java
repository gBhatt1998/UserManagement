package learn.example.demo.Controller;


import jakarta.validation.Valid;
import learn.example.demo.Model.Address;
import learn.example.demo.Model.User;
import learn.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
private UserServiceImpl service;




    @GetMapping()
    public List<User> getAllUser(){
        return service.getUserList();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = service.getUserByID(id);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
//
    @PostMapping
    public ResponseEntity<?> saveNewUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {

            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User inserted successfully");
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
     service.deletUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
//
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody User updatedUser
    ) {
        User user = service.updateUser(id, updatedUser);
        return ResponseEntity.ok("User updated successfully");
    }
    @GetMapping("/specificName/{a}")
    public List<User> getUserByPageAndDerivedName(@PathVariable  char a){
        return service.findByNameDerived(a);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @GetMapping("/createUser/{id}")
    public ResponseEntity<User> getUserWithAddress(@PathVariable Long id) {
        User user = service.getUserWithAddress(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = service.getAddressById(id);
//        System.out.print(address);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

}
