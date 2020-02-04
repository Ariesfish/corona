package xyz.ariesfish.service;

import xyz.ariesfish.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
