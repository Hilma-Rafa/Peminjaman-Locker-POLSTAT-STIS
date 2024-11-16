package com.polstat.ploker.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockerDto {
    private Long id;
    private String lockerNumber;
    private Long userId; // ID pengguna yang memiliki loker
}