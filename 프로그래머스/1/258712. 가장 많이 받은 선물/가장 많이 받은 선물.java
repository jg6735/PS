import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> nameMap = new HashMap<>();
        Map<String, Integer> fromMap = new HashMap<>();
        Map<String, Integer> toMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            fromMap.put(name, 0);
            toMap.put(name, 0);
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    map.put(friends[j], 0);
                    nameMap.put(name, map);
                }
            }
        }
        
        StringTokenizer st;
        for (String gift : gifts) {
            st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            fromMap.put(to, fromMap.get(to) + 1);
            toMap.put(from, toMap.get(from) + 1);
            nameMap.get(from).put(to, nameMap.get(from).get(to) + 1);
        }
        
        int[] arr = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            String myName = friends[i];
            for (int j = i + 1; j < friends.length; j++) {
                String friend = friends[j];
                int a = nameMap.get(myName).get(friend);
                int b = nameMap.get(friend).get(myName);
                
                if (a > b) {
                    nameMap.get(myName).put(friend, nameMap.get(myName).get(friend) + 1);
                    arr[i]++;
                } else if (b > a) {
                    nameMap.get(friend).put(myName, nameMap.get(friend).get(myName) + 1);
                    arr[j]++;
                } else if ((a == 0 && b == 0) || a == b) {
                    int aCount = toMap.get(myName) - fromMap.get(myName);
                    int bCount = toMap.get(friend) - fromMap.get(friend);
                    
                    if (aCount > bCount) {
                        nameMap.get(friend).put(myName, nameMap.get(friend).get(myName) + 1);
                        arr[i]++;
                    } else if (bCount > aCount) {
                        nameMap.get(myName).put(friend, nameMap.get(myName).get(friend) + 1);
                        arr[j]++;
                    }
                }
            }
        }
        
        for (int num : arr) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}