package nancy.service;

/**
 * @ClassName IAccountService
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/13 23:22
 * @Version 1.0
 **/

import nancy.model.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    List<Account> findAllAccount();//查询所有
    Account findAccountById(Integer id);//id查询
    void saveAccount(Account account);//保存数据
    void updateAccount(Account account);//更新数据
    void deleteAccount(Integer id);//删除数据
}
