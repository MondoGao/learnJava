package course.homework2;

public class CustomAry {
    protected int maxNum;
    protected int minNum;
    protected int value;

    protected CustomAry parentAry;

    public CustomAry(int maxNum, int minNum, int value, CustomAry parentAry) {
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.value = value;
        this.parentAry = parentAry;

        refreshValue();
    }

    public CustomAry(int maxNum, int minNum, int value) {
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.value = value;

        refreshValue();
    }

    public int getValue() {
        return value;
    }
    public int setValue(int newValue) {
        value = newValue;

        refreshValue();

        return value;
    }

    public int add(int newValue) {
        value += newValue;

        refreshValue();

        return value;
    }
    public int substract(int newValue) {
        value -= newValue;

        refreshValue();

        return value;
    }

    protected void refreshValue() {
        if (value >= maxNum) {
            int nextValue = value % maxNum + minNum;

            if (parentAry != null) {
                int parentSurplus = value / maxNum;

                parentAry.add(parentSurplus);
            }

            value = nextValue;
        } else if (value < minNum) {
            int exceedNum = minNum - value;

            if (parentAry != null) {
                int parentSurplus = exceedNum / maxNum + 1;

                parentAry.substract(parentSurplus);
            }

            value = maxNum - exceedNum % maxNum;
        }
    }
}

