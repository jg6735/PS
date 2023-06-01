package PS_Level0.영어가싫어요;

public class Solution {
    private static final String[][] number =
            {{"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
                    {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}};

    public long solution(String numbers) {
        for (String[] strings : number) {
            numbers = numbers.replace(strings[0], strings[1]);
        }

        return Long.parseLong(numbers);
    }
}