package bank;

import javax.swing.plaf.PanelUI;
import java.util.Date;

/**
 * @ClassName CheckingAccount
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/9 14:49
 * @Version 1.0
 **/
//支票账户，可以透支，有限定额
public class CheckingAccount extends Account{
    public CheckingAccount(int id, double balance, double annualIntegerRate, Date dateCreated) {
        super(id, balance, annualIntegerRate, dateCreated);
    }

    @Override
    public void outdoor(double money) {
        if(balance - money>-50000) {
            balance = balance - money;
        }
        else {
            System.out.println("透支额度不足！");
        }
    }
    public String toString() {
        return "CheckingAccount{" +
                "Id=" + getId() +
                ", balance=" + getBalance() +
                ", annualIntegerRate=" + getAnnualIntegerRate() +
                ", dateCreated=" + getDateCreated() +
                '}';
    }
}
//储蓄账户，不能透支
class SavingAccount extends Account{
    public SavingAccount(int id, double balance, double annualIntegerRate, Date dateCreated) {
        super(id, balance, annualIntegerRate, dateCreated);
    }

    public String toString() {
        return "SavingAccount{" +
                "Id=" + getId() +
                ", balance=" + getBalance() +
                ", annualIntegerRate=" + getAnnualIntegerRate() +
                ", dateCreated=" + getDateCreated() +
                '}';
    }
}
