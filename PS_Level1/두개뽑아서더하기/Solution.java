package PS_Level1.두개뽑아서더하기;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        Iterator it = set.iterator();
        int index = 0;
        while (it.hasNext()) {
            answer[index++] = (int) it.next();
        }

        return answer;
    }
}
