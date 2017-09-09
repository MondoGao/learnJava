package course.homework2;

class CustomCyclingAry extends CustomAry {
    private int[] cyclingArr;
    private int cyclingIndex = 0;

    public CustomCyclingAry(int minNum, int value, CustomAry parentAry, int[] cyclingArr, int cyclingIndex) {
        super(cyclingArr[0], minNum, value, parentAry);
        this.cyclingArr = cyclingArr;
        this.cyclingIndex = cyclingIndex;

        this.refreshMaxNum(0);
    }

    public CustomCyclingAry(int minNum, int value, int[] cyclingArr, int cyclingIndex) {
        super(cyclingArr[0], minNum, value);
        this.cyclingArr = cyclingArr;
        this.cyclingIndex = cyclingIndex;

        this.refreshMaxNum(0);

    }

    public void setCyclingIndex(int cyclingIndex) {
        this.cyclingIndex = cyclingIndex;
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

            if (parentAry != null) {
                parentAry.substract(1);
            }

            value += maxNum - minNum;

            refreshValue();
        }
    }
}
