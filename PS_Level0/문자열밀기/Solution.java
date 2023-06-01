package PS_Level0.문자열밀기;

public class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            builder.append(A.charAt(i));
        }

        for (int i = 0; i < A.length(); i++) {
            if (builder.toString().equals(B)) {
                answer = i;
                break;
            }

            builder.insert(0, A.charAt(A.length() - 1 - i));
            builder.setLength(A.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        String A = "CBAD";
        String str = "ABCD";
        String temp = str.repeat(2);

        System.out.println(temp.indexOf(A));
    }
}
