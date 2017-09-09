package course.homework1;

public class Bank {
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

