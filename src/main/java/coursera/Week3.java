package coursera;

public class Week3 {
    public static void main(String[] args) {
        eratosthenes(10000);
    }

    static void eratosthenes(int n) {
        // false 代表是素数
        boolean[] result = new boolean[n + 1];

        // 初始化 0， 1
        result[0] = true;
        result[1] = true;

        int i = 0;
        for (boolean flag : result) {
            if (!flag) {
                System.out.println(i);

                if (Math.pow(i, 2) < n) {
                    for (int j = (int) Math.pow(i, 2); j <= n; j += i) {
                        result[j] = true;
                    }
                }
            }

            i++;
        }
    }
}
