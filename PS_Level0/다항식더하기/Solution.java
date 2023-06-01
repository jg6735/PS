package PS_Level0.다항식더하기;

public class Solution {
    public String solution(String polynomial) {
        String answer = "";

        String[] arr = polynomial.replace(" ", "").split("\\+");

        int number = 0;
        int xCount = 0;
        for (String str : arr) {
            if (str.contains("x")) {
                if (str.equals("x")) {
                    xCount++;
                } else {
                    xCount += Integer.parseInt(str.replace("x", ""));
                }
            } else {
                number += Integer.parseInt(str);
            }
        }

        if (xCount != 0) {
            if (number != 0) {
                if (xCount != 1) {
                    answer = xCount + "x + " + number;
                } else {
                    answer = "x + " + number;
                }
            } else {
                if (xCount != 1) {
                    answer = xCount + "x";
                } else {
                    answer = "x";
                }
            }
        } else {
            if (number != 0) {
                answer = String.valueOf(number);
            } else {
                answer = "0";
            }
        }

        return answer;
    }
}
