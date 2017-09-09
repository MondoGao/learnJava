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
    }

    public CustomAry(int maxNum, int minNum, int value) {
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.value = value;
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
            value = maxNum - exceedNum % maxNum;
        }
    }
}

class CustomCyclingAry extends CustomAry {
    private int[] cyclingArr;
    private int cyclingIndex = 0;

    public CustomCyclingAry(int minNum, int value, CustomAry parentAry, int[] cyclingArr) {
        super(cyclingArr[0], minNum, value, parentAry);
        this.cyclingArr = cyclingArr;
    }

    public CustomCyclingAry(int minNum, int value, int[] cyclingArr) {
        super(cyclingArr[0], minNum, value);
        this.cyclingArr = cyclingArr;
    }

    private void refreshMaxNum(int direction) {
        cyclingIndex += direction;

        if (cyclingIndex >= cyclingArr.length) {
            cyclingIndex = 0;
        } else if (cyclingIndex < 0) {
            cyclingIndex = cyclingArr.length - 1;
        }

        maxNum = cyclingArr[cyclingIndex];
    }

    @Override
    protected void refreshValue() {
        if (value >= maxNum) {
            int nextValue = value - maxNum + minNum;

            if (parentAry != null) {
                parentAry.add(1);
            }

            value = nextValue;

            refreshMaxNum(1);

            refreshValue();
        } else if (value < minNum) {
            refreshMaxNum(-1);

            value += maxNum;

            refreshValue();
        }
    }
}