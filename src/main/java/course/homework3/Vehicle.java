package course.homework3;

import course.Helpers;

public class Vehicle {}

interface Sailer {
    void dock();
    void cruise();
}

interface Flyer {
    void takeOff();
    void land();
    void fly();
}

class RiverBarge extends Vehicle implements Sailer {
    public void dock() {}
    public void cruise() {}
}

class AirPlane extends Vehicle implements Flyer {
    public void takeOff() {}
    public void land() {}
    public void fly() {}
}

class seaPlane extends AirPlane implements Sailer {
    public void dock() {}
    public void cruise() {}
}

class Helicopter extends AirPlane {}

