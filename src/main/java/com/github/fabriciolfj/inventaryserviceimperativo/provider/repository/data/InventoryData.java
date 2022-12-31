package com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "inventory")
@Entity
public class InventoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String code;
    private String product;
    private long entrance;
    private long exit;
    private long balance;
    @Column(name = "date_registration")
    private LocalDateTime dateRegistration;
}
