package course;

public class Introduce {
    public String getGreeting() {
        return "来自信管 1501 江高华的问候！";
    }

    public static void main(String[] args) {
        Helpers.log(new Introduce().getGreeting());

        // Homework1
        // course.homework1.Entry.run();

        // Helpers.log("\n");

        // Homework2
        // course.homework2.Entry.run();

        // Homework3
        // course.homework3.Poker.run();

        // Homework4
        // course.homework4.MedalTally.run();

        // Homework5
        course.homework5.Task.run();
    }
}
