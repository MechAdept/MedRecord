package com.samsolutions.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "user", schema = "medrecord")
@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "from User"
        )}
)
public class User implements Serializable {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "mail")
    private String mail;
}