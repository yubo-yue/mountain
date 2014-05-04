package com.mountain.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mountain.domain.Account;
import com.mountain.service.AccountService;
import com.mountain.service.AuthenticationException;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	public static final String ACCOUNT_ATTRIBUTE = "account";
	
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String handleLogin(@RequestParam String username, @RequestParam String password,
            RedirectAttributes redirect, HttpSession session) throws AuthenticationException {
        try {
            Account account = this.accountService.login(username, password);
            session.setAttribute(ACCOUNT_ATTRIBUTE, account);
            return "redirect:/index.htm";
        } catch (AuthenticationException ae) {
            redirect.addFlashAttribute("exception", ae);
            return "redirect:/login";
        }
    }

}
