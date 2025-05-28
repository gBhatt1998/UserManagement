package learn.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "auth")
@Data
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public enum Role {
        USER, ADMIN
    }
}
