package course.homework2;

import course.Helpers;

public class Entry {
    public static void run() {
        Helpers.log("Welcome to mysterious time world.");

        Time t = new Time(23, 59);
        t.printTime();

        t.setMinute(69);
        t.printTime();

        t.setMinute(-70);
        t.printTime();

        Helpers.log("\n");

        Date d = new Date(2019, 2, 9);
        d.printDate();

        d.setDay(28);
        d.printDate();

        d.setDay(29);
        d.printDate();

        d.setDay(-1);
        d.printDate();

        d.setDay(0);
        d.printDate();

        d.setDay(0);
        d.printDate();
    }
}
