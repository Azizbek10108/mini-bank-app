package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
// Shu annotationlar bor bo'lsin:
@Data          // ← getBalance(), setBalance() shu yaratadi
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String pinCode;
    private double balance;  // ← "balanse" emas, "balance"!
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;
}