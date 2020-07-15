package nancy.dao;

import nancy.model.Account;

import java.util.List;

/**
 * @ClassName IAccountDao
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 9:45
 * @Version 1.0
 **/
public interface IAccountDao  {
    List<Account> findAllAccount();//查询所有
    Account findAccountById(Integer id);//id查询
    void saveAccount(Account account);//保存数据
    void updateAccount(Account account);//更新数据
    void deleteAccount(Integer id);//删除数据
}
