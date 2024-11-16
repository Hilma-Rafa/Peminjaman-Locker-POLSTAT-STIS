package com.polstat.ploker.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockerItemDto {
    private Long id;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private Long lockerId;
}