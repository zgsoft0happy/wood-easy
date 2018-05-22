package cn.ideacs.application.woodeasy.controller.account;

import cn.ideacs.application.woodeasy.entity.account.Account;
import cn.ideacs.application.woodeasy.service.account.AccountService;
import cn.ideacs.application.woodeasy.system.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 18-5-22 下午4:18
 * 登陆设置。
 */
@Controller
@RequestMapping(value = "login/")
public class LoginController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String username, String password) {
        Account account = accountService.getAccountByName(username);
        if (account != null && password.equals(account.getPassword())) {
            SessionFactory.createSession(account);
            return "home/home";
        } else {
            return "login";
        }
    }

}
