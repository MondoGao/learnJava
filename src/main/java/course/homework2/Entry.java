package course.homework2;

import course.Helpers;

public class Entry {
    public static void run() {
        Helpers.log("Welcome to mysterious time world.");

        CustomAry hh = new CustomAry(24, 0, 0);
        CustomAry mm = new CustomAry(60, 0, 0, hh);
    }
}
