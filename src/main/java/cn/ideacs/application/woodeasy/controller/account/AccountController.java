package cn.ideacs.application.woodeasy.controller.account;

import cn.ideacs.application.woodeasy.entity.account.Account;
import cn.ideacs.application.woodeasy.entity.enums.Education;
import cn.ideacs.application.woodeasy.entity.enums.Gender;
import cn.ideacs.application.woodeasy.entity.vos.AccountVo;
import cn.ideacs.application.woodeasy.service.account.AccountService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加注册木易网帐号
     * @param account   帐号
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addAccount(@RequestBody Account account) {
        JSONObject data = new JSONObject();
        account.setIsDelete(0);
        Account old = accountService.getAccountByName(account.getUsername());
        if (old != null) {
            data.put("msg","该用户名已经被占用！");
            return data;
        }
        Long accountId = accountService.insert(account);
        data.put("accountId", accountId);
        return data;
    }

    /**
     * 获得木易网帐号信息
     * @param userName  用户名，登录名
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public AccountVo getAccount(@RequestParam(value = "username") String userName) {
        Account account = accountService.getAccountByName(userName);
        if (account != null) {
            return buildAccount2Vo(account);
        }
        return null;
    }

    private AccountVo buildAccount2Vo(Account account) {
        AccountVo vo = new AccountVo();
        vo.setId(account.getId());
        vo.setUsername(account.getUsername());
        vo.setShowName(account.getShowName());
        vo.setRealName(account.getRealName());
        vo.setEducation(Education.getTypeName(account.getEducation()));
        vo.setPhone(account.getPhone());
        vo.setQq(account.getQq());
        vo.setEmail(account.getEmail());
        vo.setWechat(account.getWechat());
        vo.setAge(account.getAge());
        vo.setIsDelete(account.getIsDelete());
        vo.setGender(Gender.getDesc(account.getGender()));
        vo.setRemark(account.getRemark());
        return vo;
    }


}
