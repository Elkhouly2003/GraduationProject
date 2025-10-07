package com.example.GraduationBackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_ssn")
    private String ssn ;

    @Column(name = "user_role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL ,orphanRemoval = true )
    private List<Event> events;

    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Place> places ;
}
