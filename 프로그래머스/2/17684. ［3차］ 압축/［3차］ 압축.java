import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(Character.toString(c), idx++);
        }
        
        int prev = 0;
        StringBuilder builder;
        for (int i = 0; i < msg.length(); i++) {
            char cur = msg.charAt(i);
            builder = new StringBuilder(Character.toString(cur));
            prev = dictionary.get(builder.toString());
            int count = 0;
            for (int j = i + 1; j < msg.length(); j++) {
                char next = msg.charAt(j);
                builder.append(next);
                
                if (!dictionary.containsKey(builder.toString())) {
                    dictionary.put(builder.toString(), idx++);
                    result.add(prev);
                    break;
                }
                
                prev = dictionary.get(builder.toString());
                count++;
            }
            
            i += count;
        }
        
        if (prev != 0) {
            result.add(prev);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}