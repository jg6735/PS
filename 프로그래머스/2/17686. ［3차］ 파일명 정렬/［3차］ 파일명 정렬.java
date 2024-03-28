import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        String[][] list = new String[files.length][3];
        for (int i = 0; i < files.length; i++) {
            String name = files[i];
            int head = 0;
            int number = 0;
            for (int j = 0; j < name.length(); j++) {
                if (!Character.isDigit(name.charAt(j)) && Character.isDigit(name.charAt(j + 1))) {
                    head = j;
                    number = j + 1;
                    break;
                }
            }
            
            for (int j = head + 1; j < head + 5; j++) {
                if (j + 1 >= name.length()) {
                    break;
                }
                
                if (Character.isDigit(name.charAt(j))) {
                    if (Character.isDigit(name.charAt(j + 1))) {
                        number++;
                    } else {
                        break;
                    }
                }
            }
            
            list[i][0] = name.substring(0, head + 1);
            list[i][1] = name.substring(head + 1, number + 1);
            list[i][2] = name.substring(number + 1);
        }
        
        Arrays.sort(list, (o1, o2) -> {
            if (o1[0].toUpperCase().equals(o2[0].toUpperCase())) {
                int a = Integer.parseInt(o1[1]);
                int b = Integer.parseInt(o2[1]);
                
                if (a == b) {
                    return 0;
                }
                
                return a - b;
            }
            
            return o1[0].toUpperCase().compareTo(o2[0].toUpperCase());
        });
        
        for (int i = 0; i < list.length; i++) {
            answer[i] = list[i][0] + list[i][1] + list[i][2];
        }
        
        return answer;
    }

}