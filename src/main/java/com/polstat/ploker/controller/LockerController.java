package com.polstat.ploker.controller;

import com.polstat.ploker.dto.LockerItemDto;
import com.polstat.ploker.dto.LockerDto;
import com.polstat.ploker.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lockers")
public class LockerController {

    @Autowired
    private LockerService lockerService;

    // Endpoint untuk memberikan loker kepada user
    @PostMapping("/assign")
    public LockerDto assignLocker(@RequestParam Long userId) {
        return lockerService.assignLocker(userId);
    }

    // Endpoint untuk mengambil semua barang di dalam loker
    @GetMapping("/{lockerId}/items")
    public List<LockerItemDto> getLockerItems(@PathVariable Long lockerId) {
        return lockerService.getLockerItems(lockerId);
    }

    // Endpoint untuk mencari barang berdasarkan jenis
    @GetMapping("/items/search")
    public List<LockerItemDto> searchItemsByType(@RequestParam String itemType) {
        return lockerService.searchItemsByType(itemType);
    }
}