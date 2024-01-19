package pl.kathelan.jpainherittest.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@RequiredArgsConstructor
public class User {
    public enum UserType {
        USER, EXTENDED_USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;

}
