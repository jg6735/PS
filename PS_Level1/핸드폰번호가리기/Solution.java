package PS_Level1.핸드폰번호가리기;

public class Solution {
    public String solution(String phone_number) {
        return "*".repeat(phone_number.length() - 4) + phone_number.substring(phone_number.length() - 4);
    }
}
