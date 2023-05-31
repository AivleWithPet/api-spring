package com.example.apispring.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class IrisDataDto {
    private Integer sepalLength;
    private Integer sepalWidth;
    private Integer petalLength;
    private Integer petalWidth;
}
