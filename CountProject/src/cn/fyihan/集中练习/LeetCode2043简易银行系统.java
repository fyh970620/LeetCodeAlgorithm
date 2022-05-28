package cn.fyihan.集中练习;

public class LeetCode2043简易银行系统 {

    private long[] balance;

    public LeetCode2043简易银行系统(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1-1 <0 || account2-1 < 0 || account1-1 >= balance.length ||
                account2 -1 >=balance.length || balance[account1-1] < money) {
            return false;
        }
        balance[account1-1] -= money;
        balance[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account-1 <0 || account-1 >= balance.length) {
            return false;
        }
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account-1 < 0 || account-1 >= balance.length || balance[account -1] < money) {
            return false;
        }
        balance[account-1] -= money;
        return true;
    }
}
