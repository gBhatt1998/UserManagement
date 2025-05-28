package learn.example.demo.Controller;



import learn.example.demo.Dto.AuthRequest;
import learn.example.demo.Dto.AuthResponse;
import learn.example.demo.Dto.RegisterRequest;
import learn.example.demo.Model.Auth;
import learn.example.demo.Model.User;
import learn.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Auth> register(@RequestBody RegisterRequest request) {
        Auth registeredUser = authService.register(request);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.authenticate(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(response);
    }
}

