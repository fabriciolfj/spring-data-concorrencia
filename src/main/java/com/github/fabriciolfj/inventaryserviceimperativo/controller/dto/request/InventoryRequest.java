package com.github.fabriciolfj.inventaryserviceimperativo.controller.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {

    private String product;
    private long quantity;
    private String operation;
}
