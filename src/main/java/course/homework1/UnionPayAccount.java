package course.homework1;

import course.Helpers;

abstract class UnionPayAccount implements UnionPayProtocol {
    private double balance = 0;
    public String name = "";

    public UnionPayAccount(double initBalance) {
        balance = initBalance;
    }

    public UnionPayAccount(double initBalance, String name) {
        balance = initBalance;
        this.name = name;
    }

    public boolean isBalanceEnough(double money) {
        return balance >= money;
    }

    public boolean deposit(double money) {
        try {
            balance += money;
        } catch(Exception e) {
            Helpers.log("Deposit failed.");
            return false;
        }

        return true;
    }

    public boolean withdraw(double money) {
        if (isBalanceEnough(money)) {
            balance -= money;
            return true;
        }

        Helpers.log("Withdraw failed.");
        return false;
    }

    public boolean transferTo(double money, UnionPayProtocol targetAccount) {
        if (withdraw(money)) {
            targetAccount.deposit(money);

            return true;
        }

        Helpers.log("Transfer failed.");
        return false;
    }

    public void printBalance() {
        Helpers.log(name + "'s balance: " + String.valueOf(balance));
    }
}
