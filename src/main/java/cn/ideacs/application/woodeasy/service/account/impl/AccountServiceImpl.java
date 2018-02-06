package cn.ideacs.application.woodeasy.service.account.impl;

import cn.ideacs.application.woodeasy.dao.account.AccountMapper;
import cn.ideacs.application.woodeasy.entity.account.Account;
import cn.ideacs.application.woodeasy.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Thomas.yang
 * personal page is <a href='www.ideacs.cn'>ideacs</a>
 * 18-2-6   下午9:47
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Long insert(Account account) {
        accountMapper.insert(account);
        return account.getId();
    }

    @Override
    public Long update(Account account) {
        accountMapper.update(account);
        return account.getId();
    }

    @Override
    public Account getById(Long id) {
        return accountMapper.getById(id);
    }

    @Override
    public List<Account> list(Integer offset, Integer rows) {
        return accountMapper.list(offset,rows);
    }

    @Override
    public void deleteById(Long id) {
        accountMapper.deleteById(id);
    }
}
