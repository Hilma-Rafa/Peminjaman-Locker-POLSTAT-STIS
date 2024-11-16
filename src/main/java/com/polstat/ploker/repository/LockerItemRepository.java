package com.polstat.ploker.repository;

import com.polstat.ploker.entity.LockerItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockerItemRepository extends JpaRepository<LockerItem, Long> {
    List<LockerItem> findByLockerId(Long lockerId); // Temukan item berdasarkan ID Locker
    List<LockerItem> findByItemType(String itemType); // Temukan item berdasarkan jenis barang
}