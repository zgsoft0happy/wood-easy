package cn.ideacs.application.woodeasy.service.account;

import cn.ideacs.application.woodeasy.entity.account.Account;

import java.util.List;

/**
 * Create by Thomas.yang
 * personal page is <a href='www.ideacs.cn'>ideacs</a>
 * 18-2-6   下午9:44
 */
public interface AccountService {

    Long insert(Account account);

    Long update(Account account);

    Account getById(Long id);

    List<Account> list(Integer offset, Integer rows);

    void deleteById(Long id);
}
