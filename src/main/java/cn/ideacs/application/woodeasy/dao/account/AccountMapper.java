package cn.ideacs.application.woodeasy.dao.account;

import cn.ideacs.application.woodeasy.entity.account.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
public interface AccountMapper {

    /**
     * 新增用户
     * @param account
     * @return  用户ID
     */
    Long insert(Account account);

    /**
     * 编辑用户
     * @param account
     */
    void update(Account account);

    /**
     * 根据ID查询用户列表
     * @param id    用户ID
     * @return      账户信息
     */
    Account getById(@Param("id")Long id);

    /**
     * 获得用户列表
     * @param offset    分页偏移量
     * @param rows      分页大小
     * @return  用户集合
     */
    List<Account> list(@Param("offset")Integer offset, @Param("rows")Integer rows);

    /**
     * 根据用户ID删除用户
     * @param id    用户ID.
     */
    void deleteById(@Param("id")Long id);

    Account getAccountByName(@Param("username") String userName);

}
