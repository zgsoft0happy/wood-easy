package cn.ideacs.application.woodeasy.controller.account;

import cn.ideacs.application.woodeasy.entity.account.Account;
import cn.ideacs.application.woodeasy.service.account.AccountService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by Thomas.yang
 * personal page is <a href='www.ideacs.cn'>ideacs</a>
 * 18-2-6   下午9:54
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addAccount(@RequestBody Account account) {
        account.setIsDelete(0);
        Long accountId = accountService.insert(account);
        JSONObject data = new JSONObject();
        data.put("accountId", accountId);
        return data;
    }

}
