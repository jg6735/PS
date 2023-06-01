package PS_Level0.이진수더하기;

public class Solution {
    public String solution(String bin1, String bin2) {
        int num1 = 0;
        int num2 = 0;
        int depth = 0;
        for (int i = bin1.length() - 1; i >= 0; i--) {
            if (bin1.charAt(i) - '0' == 1) {
                num1 += Math.pow(2, depth);
            }

            depth++;
        }

        depth = 0;
        for (int i = bin2.length() - 1; i >= 0; i--) {
            if (bin2.charAt(i) - '0' == 1) {
                num2 += Math.pow(2, depth);
            }

            depth++;
        }

        return Integer.toBinaryString(num1 + num2);

        // Integer.parseInt 의 radix (밑, 기수)를 이용해 더 간단하게 해결
        // return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2), 2);
        // return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }
}
