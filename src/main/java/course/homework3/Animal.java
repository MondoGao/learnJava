package course.homework3;

import course.Helpers;

public abstract class Animal {
    public void eat() {
        Helpers.log("Eating...");
    }
}

interface Pet {
    void play();
}

class Cat extends Animal implements Pet {
    public void play() {
        Helpers.log("Your pet is playing with you.");
    }
}
