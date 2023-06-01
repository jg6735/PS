package PS_Level0.배열뒤집기;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] num_list) {
//        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
//        Collections.reverse(list);
//        return list.stream().mapToInt(i -> i).toArray();
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - i - 1];
        }
        return answer;
    }
}
