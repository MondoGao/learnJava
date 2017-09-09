package course;

public class Homework_Bank {
    public static void run() {
        System.out.println("Welcome to FakeUnionPay checkout system.");

        UnionPayAccount acc1 = new BOCAccount(100, "BOC");
        UnionPayAccount acc2 = new ICBCAccount(1000, "ICBC");

        acc1.deposit(28.8);
        acc1.printBalance();

        acc1.withdraw(130);

        acc1.printBalance();
        acc2.printBalance();

        acc1.transferTo(128.8, acc2);

        acc1.printBalance();
        acc2.printBalance();
    }
}

interface UnionPayProtocol {
    boolean isBalanceEnough(double money);
    
    boolean deposit(double money);
    boolean withdraw(double money);

    boolean transferTo(double money, UnionPayProtocol targetAccount);

    void printBalance();
}

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

class BOCAccount extends UnionPayAccount {
    public static String bankName = "BOC";

    public BOCAccount(double initBalance, String name) {
        super(initBalance, name);
    }
}

class ICBCAccount extends UnionPayAccount {
    public static String bankName = "ICBC";

    public ICBCAccount(double initBalance, String name) {
        super(initBalance, name);
    }
}
