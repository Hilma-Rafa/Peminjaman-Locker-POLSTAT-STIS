package com.polstat.ploker.service;

import com.polstat.ploker.dto.LockerItemDto;
import com.polstat.ploker.dto.LockerDto;
import com.polstat.ploker.entity.Locker;
import com.polstat.ploker.entity.LockerItem;
import com.polstat.ploker.entity.User;
import com.polstat.ploker.mapper.LockerItemMapper;
import com.polstat.ploker.mapper.LockerMapper;
import com.polstat.ploker.repository.LockerRepository;
import com.polstat.ploker.repository.LockerItemRepository;
import com.polstat.ploker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LockerServiceImpl implements LockerService {

    private final LockerRepository lockerRepository;
    private final UserRepository userRepository;
    private final LockerItemRepository lockerItemRepository;

    // Constructor injection untuk LockerRepository, UserRepository, dan LockerItemRepository
    @Autowired
    public LockerServiceImpl(LockerRepository lockerRepository, UserRepository userRepository, LockerItemRepository lockerItemRepository) {
        this.lockerRepository = lockerRepository;
        this.userRepository = userRepository;
        this.lockerItemRepository = lockerItemRepository;
    }

    @Override
    public LockerDto assignLocker(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if user already has a locker
        Locker existingLocker = lockerRepository.findByUser(user);
        if (existingLocker != null) {
            throw new RuntimeException("User already has a locker assigned.");
        }

        Locker locker = Locker.builder()
                .lockerNumber("LOCKER_" + System.currentTimeMillis())  // Generate unique locker number
                .user(user)
                .build();
        lockerRepository.save(locker);
        return LockerMapper.mapToLockerDto(locker);  // Convert to DTO and return
    }

    @Override
    public List<LockerItemDto> getLockerItems(Long lockerId) {
        Locker locker = lockerRepository.findById(lockerId)
                .orElseThrow(() -> new RuntimeException("Locker not found"));

        // Convert LockerItem entities to DTOs
        return locker.getItems().stream()
                .map(LockerItemMapper::mapToLockerItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LockerItemDto> searchItemsByType(String itemType) {
        // Cari barang berdasarkan jenis di seluruh locker
        List<LockerItem> lockerItems = lockerItemRepository.findByItemType(itemType);
        return lockerItems.stream()
                .map(LockerItemMapper::mapToLockerItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public LockerItemDto updateItem(Long itemId, LockerItemDto itemDto) {
        // Menemukan item berdasarkan itemId
        LockerItem lockerItem = lockerItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // Update item dengan data baru dari itemDto
        lockerItem.setItemName(itemDto.getItemName());
        lockerItem.setItemType(itemDto.getItemType());
        lockerItem.setItemDescription(itemDto.getItemDescription());

        lockerItemRepository.save(lockerItem);

        // Return updated item in DTO format
        return LockerItemMapper.mapToLockerItemDto(lockerItem);
    }

    @Override
    public List<LockerItemDto> getAllItems() {
        // Mengambil semua item dari semua locker
        List<LockerItem> items = lockerItemRepository.findAll();
        return items.stream()
                .map(LockerItemMapper::mapToLockerItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LockerDto> getAllLockers() {
        // Mengambil semua locker
        List<Locker> lockers = lockerRepository.findAll();
        return lockers.stream()
                .map(LockerMapper::mapToLockerDto)
                .collect(Collectors.toList());
    }
}