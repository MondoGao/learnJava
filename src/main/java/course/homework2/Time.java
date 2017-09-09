package course.homework2;

import course.Helpers;

public class Time {
    CustomAry hh;
    CustomAry mm;

    public Time(int hh, int mm) {
        this.hh = new CustomAry(24, 0, hh);
        this.mm = new CustomAry(60, 0, mm, this.hh);
    }

    public int getHour() {
        return hh.getValue();
    }
    public int setHour(int hh) {
        return this.hh.setValue(hh);
    }

    public int getMinute() {
        return mm.getValue();
    }
    public int setMinute(int mm) {
        return this.mm.setValue(mm);
    }

    public void printTime() {
        Helpers.log(getHour() + " : " + getMinute());
    }
}
