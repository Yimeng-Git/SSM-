package com.yym.service.impl;

import com.yym.dao.AccountMapper;
import com.yym.domain.Account;
import com.yym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void save(Account account) {
           /* InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);*/
        accountMapper.save(account);
    }

    @Override
    public List<Account> fandAll() {
        /*try {
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);*/
        List<Account> accounts = accountMapper.fandAll();
        for (Account account1 : accounts) {
            System.out.println(account1);
        }
        return accounts;
       /* } catch (IOException e) {
            e.printStackTrace();
        }
        return null;*/
    }
}
