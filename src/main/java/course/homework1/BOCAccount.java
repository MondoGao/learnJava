package course.homework1;

class BOCAccount extends UnionPayAccount {
    public static String bankName = "BOC";

    public BOCAccount(double initBalance, String name) {
        super(initBalance, name);
    }
}
