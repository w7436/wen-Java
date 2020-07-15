package nancy.service;

/**
 * @ClassName IAccountService
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 16:06
 * @Version 1.0
 **/
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();
    void updateAccount(int i);
    int deleteAccount();

}
