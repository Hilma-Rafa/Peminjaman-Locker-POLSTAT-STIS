package com.polstat.ploker.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String itemType;

    @Column(nullable = true)
    private String itemDescription;

    // Relasi ManyToOne dengan Locker
    @ManyToOne
    @JoinColumn(name = "locker_id", referencedColumnName = "id", nullable = false)
    private Locker locker;
}