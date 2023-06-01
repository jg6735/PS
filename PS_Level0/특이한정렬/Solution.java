package PS_Level0.특이한정렬;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] numlist, int n) {
/*        List<Integer> list = new ArrayList<>();
        Arrays.sort(numlist);
        for (int num : numlist) {
            list.add(num);
        }

        list.sort((s1, s2) -> Integer.compare(Math.abs(s2 - n), Math.abs(s1 - n)));

        Collections.reverse(list);
        return list.stream().mapToInt(num -> num).toArray();*/

        List<Integer> list = Arrays.stream(numlist).boxed().collect(Collectors.toList());
        list.sort(((o1, o2) -> Math.abs(o1 - n) != Math.abs(o2 - n) ? Math.abs(o1 - n) - Math.abs(o2 - n) : o2 - o1));
        return list.stream().mapToInt(num -> num).toArray();
    }
}
