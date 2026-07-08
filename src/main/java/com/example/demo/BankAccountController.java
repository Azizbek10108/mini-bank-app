package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")  // ← shu qatorni qo'sh
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountServise bankAccountService;

    // Controller:
    @PostMapping
    public ResponseEntity<BankAccount> create(
            @RequestBody CreateAccountRequest request) {
        BankAccount account = BankAccount.builder()
                .fullname(request.getFullname())
                .pinCode(request.getPinCode())
                .phone(request.getPhone())
                .balance(0.0)
                .build();
        return ResponseEntity.ok(bankAccountService.create(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(bankAccountService.getById(id));
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<BankAccount> deposit(
            @PathVariable Long id,
            @RequestParam double amount,
            @RequestParam String pinCode) {
        return ResponseEntity.ok(
                bankAccountService.deposit(id, amount, pinCode));
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<BankAccount> withdraw(
            @PathVariable Long id,
            @RequestParam double amount,
            @RequestParam String pinCode) {
        return ResponseEntity.ok(
                bankAccountService.withdraw(id, amount, pinCode));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam double amount,
            @RequestParam String pinCode) {
        return ResponseEntity.ok(
                bankAccountService.transfer(fromId, toId, amount, pinCode));
    }
}