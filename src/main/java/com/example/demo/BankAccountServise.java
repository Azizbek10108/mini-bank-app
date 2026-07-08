package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankAccountServise {

    private final BankAccountrepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public BankAccount create(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getById(Long id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hisob topilmadi"));
    }

    public BankAccount deposit(Long id, double amount, String pinCode) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hisob topilmadi"));

        if (!account.getPinCode().equals(pinCode)) {
            throw new RuntimeException("PIN noto'g'ri!");
        }

        if (amount <= 0) {
            throw new RuntimeException("Summa 0 dan katta bo'lsin!");
        }

        account.setBalance(account.getBalance() + amount);
        return bankAccountRepository.save(account);
    }

    public BankAccount withdraw(Long id, double amount, String pinCode) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hisob topilmadi"));

        if (!account.getPinCode().equals(pinCode)) {
            throw new RuntimeException("PIN noto'g'ri!");
        }

        if (amount > account.getBalance()) {
            throw new RuntimeException("Mablag' yetarli emas!");
        }

        account.setBalance(account.getBalance() - amount);
        return bankAccountRepository.save(account);
    }

    @Transactional
    public String transfer(Long fromId, Long toId,
                           double amount, String pinCode) {
        BankAccount from = bankAccountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Hisob topilmadi"));

        BankAccount to = bankAccountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Hisob topilmadi"));

        if (!from.getPinCode().equals(pinCode)) {
            throw new RuntimeException("PIN noto'g'ri!");
        }

        if (from.getBalance() < amount) {
            throw new RuntimeException("Mablag' yetarli emas!");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        com.example.demo.Transactional transaction = com.example.demo.Transactional.builder()
                .fromAccountId(fromId)
                .toAccountId(toId)
                .amount(amount)
                .status("SUCCESS")
                .build();

        transactionRepository.save(transaction);
        bankAccountRepository.save(from);
        bankAccountRepository.save(to);

        return "Muvaffaqiyatli! " + amount + " so'm yuborildi";
    }
}