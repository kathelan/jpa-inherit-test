package pl.kathelan.jpainherittest.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Table(name = "extended_users")
@PrimaryKeyJoinColumn(name = "id")
@Entity
@Data
public class ExtendedUser extends User {

    @Column(name = "third_name")
    private String thirdName;

    public ExtendedUser() {
    }
}