package PS_Level0.인덱스바꾸기;

public class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder builder = new StringBuilder();
        builder.append(my_string)
                .deleteCharAt(num1)
                .insert(num1, my_string.charAt(num2))
                .deleteCharAt(num2)
                .insert(num2, my_string.charAt(num1));

        return builder.toString();
    }
}
