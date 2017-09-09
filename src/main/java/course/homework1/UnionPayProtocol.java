package course.homework1;

interface UnionPayProtocol {
    boolean isBalanceEnough(double money);

    boolean deposit(double money);
    boolean withdraw(double money);

    boolean transferTo(double money, UnionPayProtocol targetAccount);

    void printBalance();
}
