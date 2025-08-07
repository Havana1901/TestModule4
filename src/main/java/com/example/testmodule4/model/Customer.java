package com.example.testmodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "khach_hang")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;

}
