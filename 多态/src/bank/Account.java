package bank;

import java.util.Date;

/**
 * @ClassName Account
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/9 14:35
 * @Version 1.0
 **/

//账户类
public class Account {
    protected int Id;
    protected double balance;//余额
    protected double annualIntegerRate;//年利率
    protected Date dateCreated;

    public Account() {
    }

    public Account(int id, double balance, double annualIntegerRate, Date dateCreated) {
        Id = id;
        this.balance = balance;
        this.annualIntegerRate = annualIntegerRate;
        this.dateCreated = dateCreated;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getAnnualIntegerRate() {
        return annualIntegerRate;
    }
    public void setAnnualIntegerRate(double annualIntegerRate) {
        this.annualIntegerRate = annualIntegerRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    //存款
    public void indoor(double money){
        balance = balance+money;

    }
    public void outdoor(double money){
        if(balance - money < 0){
            System.out.println("余额不足");
        }
        balance = balance- money;
    }
    @Override
    public String toString() {
        return "Account{" +
                "Id=" + getId() +
                ", balance=" + getBalance() +
                ", annualIntegerRate=" + getAnnualIntegerRate() +
                ", dateCreated=" + getDateCreated() +
                '}';
    }
}
