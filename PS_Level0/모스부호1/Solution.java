package PS_Level0.모스부호1;

public class Solution {
    private static final String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public String solution(String letter) {
        String answer = "";

        String[] arr = letter.split(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < morseCodes.length; j++) {
                if (arr[i].equals(morseCodes[j])) {
                    answer += Character.toString('a' + j);
                }
            }
        }

        return answer;
    }
}
