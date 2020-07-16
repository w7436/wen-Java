package nancy.service.impl;

import nancy.service.IAccountService;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 16:09
 * @Version 1.0
 **/
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);

    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
