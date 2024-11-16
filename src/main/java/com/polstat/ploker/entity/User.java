package com.polstat.ploker.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Relasi OneToMany dengan Locker, satu user bisa memiliki banyak locker
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Locker> lockers;
}