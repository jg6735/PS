package PS_Level0.소인수분해;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        if (n != 1) {
            set.add(n);
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < answer.length; i++) {
            if (it.hasNext()) {
                answer[i] = it.next();
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}
