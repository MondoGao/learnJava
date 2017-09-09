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
    }
}
