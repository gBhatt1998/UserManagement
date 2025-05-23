package learn.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long  id;

   @NotBlank(message = "Name is required")
   @Column(nullable = false)
   private String name;
   @Column
   private String hobby;
   @Column
   private String email;
   @Min(value = 18, message = "Age must be at least 18")
   @Column
   private int age;
}