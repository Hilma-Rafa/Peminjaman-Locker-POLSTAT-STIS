package com.polstat.ploker.repository;

import com.polstat.ploker.entity.Locker;
import com.polstat.ploker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long> {
    Locker findByUser(User user); // Query untuk mencari locker berdasarkan pengguna
}