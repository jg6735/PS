package PS_Level0.문자열정렬하기1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            int number = my_string.charAt(i) - '0';
            if (number >= 0 && number <= 9) {
                list.add(number);
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}
