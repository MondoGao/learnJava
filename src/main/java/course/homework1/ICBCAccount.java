package course.homework1;

class ICBCAccount extends UnionPayAccount {
    public static String bankName = "ICBC";

    public ICBCAccount(double initBalance, String name) {
        super(initBalance, name);
    }
}
