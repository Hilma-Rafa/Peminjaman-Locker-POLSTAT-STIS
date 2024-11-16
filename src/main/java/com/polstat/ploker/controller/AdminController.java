package com.polstat.ploker.controller;

import com.polstat.ploker.dto.LockerDto;
import com.polstat.ploker.dto.LockerItemDto;
import com.polstat.ploker.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')") // Ensure only admin has access
public class AdminController {

    @Autowired
    private LockerService lockerService;

    @GetMapping("/lockers")
    public ResponseEntity<List<LockerDto>> getAllLockers() {
        List<LockerDto> lockers = lockerService.getAllLockers();
        return ResponseEntity.ok(lockers);
    }

    @GetMapping("/items")
    public ResponseEntity<List<LockerItemDto>> getAllItems() {
        List<LockerItemDto> items = lockerService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<LockerItemDto> updateItem(@PathVariable Long itemId, @Valid @RequestBody LockerItemDto itemDto) {
        LockerItemDto updatedItem = lockerService.updateItem(itemId, itemDto);
        return ResponseEntity.ok(updatedItem);
    }
}