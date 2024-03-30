import java.util.*;

class Solution {
    private static final char[] CHARACTERS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    private static int answer;
    private static boolean[] isSelected;
    private static char[][] conditions;
    private static Map<Character, Integer> map;
    
    public int solution(int n, String[] data) {
        init(n, data);
        search(0, conditions);
        return answer;
    }
    
    private void init(int n, String[] data) {
        answer = 0;
        isSelected = new boolean[8];
        map = new HashMap<>();
        conditions = initCond(n, data);
    }
    
    private char[][] initCond(int n, String[] data) {
        conditions = new char[n][4];
        for (int i = 0; i < n; i++) {
            String d = data[i];
            conditions[i][0] = data[i].charAt(0);
            conditions[i][1] = data[i].charAt(2);
            conditions[i][2] = data[i].charAt(3);
            conditions[i][3] = data[i].charAt(4);
        }
        
        return conditions;
    }
    
    private void search(int cnt, char[][] conditions) {
        if (cnt == 8) {
            for (char[] condition : conditions) {
                char a = condition[0];
                char b = condition[1];
                char op = condition[2];
                int size = condition[3] - '0';
                
                int aIdx = map.get(a);
                int bIdx = map.get(b);
                if (!isAvailable(aIdx, bIdx, op, size)) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (isSelected[i]) {
                continue;
            }
            
            map.put(CHARACTERS[i], cnt);
            isSelected[i] = true;
            search(cnt + 1, conditions);
            isSelected[i] = false;
        }
    }
    
    private boolean isAvailable(int aIdx, int bIdx, char op, int size) {
        if (op == '=' && Math.abs(aIdx - bIdx) == size + 1) {
            return true;
        } else if (op == '<' && Math.abs(aIdx - bIdx) < size + 1) {
            return true;
        } else if (op == '>' && Math.abs(aIdx - bIdx) > size + 1) {
            return true;
        } else {
            return false;
        }
    }
}