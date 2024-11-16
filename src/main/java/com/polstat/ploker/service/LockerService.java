package com.polstat.ploker.service;

import com.polstat.ploker.dto.LockerDto;
import com.polstat.ploker.dto.LockerItemDto;
import jakarta.validation.Valid;

import java.util.List;

public interface LockerService {

    LockerDto assignLocker(Long userId);  // Method to assign a locker to a user

    List<LockerItemDto> getLockerItems(Long lockerId);  // Get all items in a specific locker

    List<LockerItemDto> searchItemsByType(String itemType);  // Search for items in lockers by type

    LockerItemDto updateItem(Long itemId, @Valid LockerItemDto itemDto);  // Update an item in the locker

    List<LockerItemDto> getAllItems();  // Get all items from all lockers

    List<LockerDto> getAllLockers();  // Get all lockers
}