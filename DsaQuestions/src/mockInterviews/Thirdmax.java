package mockInterviews;

import java.util.HashMap;
import java.util.Map;

public class Thirdmax {
    public static void thirdMaxChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
        }
        int max = 0, secondMax = 0, ThirdMax = 0;
        for (Map.Entry<Character, Integer> item : hm.entrySet()) {
            // char c= item.getKey();
            int val = item.getValue();

            if (val > max) {
                ThirdMax = secondMax;
                secondMax = max;
                max = val;
            } else if (val > secondMax) {
                ThirdMax = secondMax;
                secondMax = val;
            } else if (val > ThirdMax) {
                ThirdMax = val;
            }

        }

        System.out.println(ThirdMax);
    }

    public static void main(String[] args) {

        thirdMaxChar("AAABBC");
    }
}
