package com.polstat.ploker.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String lockerNumber;

    // Relasi ManyToOne dengan User, satu user memiliki banyak locker
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Menghubungkan dengan kolom user_id
    private User user;

    // Relasi OneToMany dengan LockerItem, satu locker memiliki banyak barang
    @OneToMany(mappedBy = "locker", cascade = CascadeType.ALL)  // mappedBy menunjuk pada field "locker" di LockerItem
    private List<LockerItem> items;
}