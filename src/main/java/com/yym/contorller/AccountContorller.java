package com.yym.contorller;

import com.yym.domain.Account;
import com.yym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountContorller {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
        return "Success";
    }

    @RequestMapping("/fandAll")
    public ModelAndView fandAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accounts = accountService.fandAll();
        modelAndView.addObject("accounts", accounts);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
