package course.homework4;

import java.util.ArrayList;
import java.util.Collections;

public class MedalTally {
    public static class Score implements Comparable<Score> {
        private int goldNum;
        private int silverNum;
        private int bronzeNum;
        private String name;

        @Override
        public String toString() {
            return this.name + ": Gold " + this.goldNum + ", Silver " + this.silverNum + ", Bronze " + this.bronzeNum;
        }

        @Override
        public int compareTo(Score o) {
            int result = Integer.compare(this.getGoldNum(), o.getGoldNum());
            if (result == 0) {
                result = Integer.compare(this.getSilverNum(), o.getSilverNum());
            }
            if (result == 0) {
                result = Integer.compare(this.getBronzeNum(), o.getBronzeNum());
            }
            return -result;
        }

        public Score(int goldNum, int silverNum, int bronzeNum, String name) {
            this.goldNum = goldNum;
            this.silverNum = silverNum;
            this.bronzeNum = bronzeNum;
            this.name = name;
        }

        public int getGoldNum() {
            return goldNum;
        }

        public void setGoldNum(int goldNum) {
            this.goldNum = goldNum;
        }

        public int getSilverNum() {
            return silverNum;
        }

        public void setSilverNum(int silverNum) {
            this.silverNum = silverNum;
        }

        public int getBronzeNum() {
            return bronzeNum;
        }

        public void setBronzeNum(int bronzeNum) {
            this.bronzeNum = bronzeNum;
        }

        public int getTotalNum() {
            return goldNum + silverNum + bronzeNum;
        }
    }

    public static void run() {
        ArrayList<Score> tally = new ArrayList<>();
        tally.add(new Score(1,2,3, "China"));
        tally.add(new Score(0,0,2, "UK"));
        tally.add(new Score(0,1,3, "USA"));

        Collections.sort(tally);

        for (Score t : tally) {
            System.out.println(t);
        }
    }
}
