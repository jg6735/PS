package PS_Level0.외계어사전;

public class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        for (int i = 0; i < dic.length; i++) {
            boolean check = false;
            if (dic[i].length() == spell.length) {
                for (int j = 0; j < dic[i].length(); j++) {
                    if (!dic[i].contains(spell[j])) {
                        check = false;
                        break;
                    } else {
                        check = true;
                    }
                }

                if (check) {
                    return 1;
                }
            }
        }

        return answer;
    }
}
