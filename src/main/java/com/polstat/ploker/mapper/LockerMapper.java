package com.polstat.ploker.mapper;

import com.polstat.ploker.dto.LockerDto;
import com.polstat.ploker.entity.Locker;

public class LockerMapper {

    public static LockerDto mapToLockerDto(Locker locker) {
        return LockerDto.builder()
                .id(locker.getId())
                .lockerNumber(locker.getLockerNumber())
                .userId(locker.getUser().getId())
                .build();
    }
}