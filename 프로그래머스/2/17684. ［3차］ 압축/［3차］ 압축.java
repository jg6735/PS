import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(Character.toString(c), idx++);
        }
        
        char[] arr = msg.toCharArray();
        List<Integer> result = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            StringBuilder sb = new StringBuilder(Character.toString(c));
            n = map.get(sb.toString());
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                char next = arr[j];
                sb.append(next);
                if (!map.containsKey(sb.toString())) {
                    result.add(n);
                    map.put(sb.toString(), idx++);
                    break;
                } else {
                    n = map.get(sb.toString());
                    count++;
                }
            }
            
            i += count;
        }
        
        if (n != 0) {
            result.add(n);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}