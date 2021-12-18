package com.yym.dao;

import com.yym.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Insert("insert into account values (null, #{name}, #{money})")
    public void save(Account account);

    @Select("select * from account")
    public List<Account> fandAll();
}
