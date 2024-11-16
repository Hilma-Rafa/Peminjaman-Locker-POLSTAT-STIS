package com.polstat.ploker.mapper;

import com.polstat.ploker.dto.LockerItemDto;
import com.polstat.ploker.entity.LockerItem;

public class LockerItemMapper {

    public static LockerItemDto mapToLockerItemDto(LockerItem item) {
        return LockerItemDto.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .itemType(item.getItemType())
                .itemDescription(item.getItemDescription())
                .lockerId(item.getLocker().getId())  // Mendapatkan ID loker terkait
                .build();
    }
}