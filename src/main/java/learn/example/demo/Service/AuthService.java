// AuthService.java
package learn.example.demo.service;

import learn.example.demo.Dto.AuthResponse;
import learn.example.demo.Dto.RegisterRequest;
import learn.example.demo.Model.Auth;
import learn.example.demo.Model.User;
import learn.example.demo.Repository.AuthRepository;
import learn.example.demo.Repository.UserRepository;
import learn.example.demo.security.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private  AuthRepository authRepository;
    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  JwtTokenUtil jwtTokenUtil;
    private  AuthenticationManager authenticationManager;
    public AuthService(AuthRepository authRepository,
                       UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenUtil jwtTokenUtil,
                       AuthenticationManager authenticationManager) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }
    public AuthResponse authenticate(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        Auth auth = authRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtTokenUtil.generateToken(
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal());

        return new AuthResponse(token, auth.getUsername(), auth.getRole().name());
    }

    public Auth register(RegisterRequest request) {
        if (authRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setName(request.getUsername());


        Auth auth = new Auth();
        auth.setUsername(request.getUsername());
        auth.setPassword(passwordEncoder.encode(request.getPassword()));
        auth.setRole(Auth.Role.USER);
//        auth.setUser(user);

//        user.setAuth(auth);
        return authRepository.save(auth);
    }
}