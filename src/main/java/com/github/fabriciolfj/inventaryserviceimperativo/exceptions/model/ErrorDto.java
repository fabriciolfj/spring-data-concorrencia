package com.github.fabriciolfj.inventaryserviceimperativo.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private int status;
    private String message;
}
