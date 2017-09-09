package course.homework2;

import course.Helpers;

public class Date {
    CustomAry yy;
    CustomAry mm;
    CustomAry dd;

    public static final int[] monthCycle = { 32, 29, 32, 31, 32, 31, 32, 32, 31, 32, 31, 32};

    public Date(int yy, int mm, int dd) {
        this.yy = new CustomAry(Integer.MAX_VALUE, 0, yy);
        this.mm = new CustomAry(13, 1, mm, this.yy);
        this.dd = new CustomCyclingAry(1, dd, this.mm, Date.monthCycle, 1);
    }

    public int getYear() {
        return yy.getValue();
    }
    public int setYear(int yy) {
        return this.yy.setValue(yy);
    }

    public int getMonth() {
        return mm.getValue();
    }
    public int setMonth(int mm) {
        return this.mm.setValue(mm);
    }

    public int getDay() {
        return dd.getValue();
    }
    public int setDay(int dd) {
        return this.dd.setValue(dd);
    }

    public void printDate() {
        Helpers.log(getYear() + "." + getMonth() + '.' + getDay());
    }
}
