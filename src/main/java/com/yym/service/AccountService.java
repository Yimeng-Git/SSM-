package com.yym.service;

import com.yym.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> fandAll();
}
