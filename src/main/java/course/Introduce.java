package course;

import course.homework1.Bank;

public class Introduce {
    public String getGreeting() {
        return "来自信管 1501 江高华的问候！";
    }

    public static void main(String[] args) {
        Helpers.log(new Introduce().getGreeting());

        // Homework1
        Bank.run();
    }
}
