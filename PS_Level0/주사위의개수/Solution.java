package PS_Level0.주사위의개수;

public class Solution {
    public int solution(int[] box, int n) {
        return box[0] / n * box[1] / n * box[2] / n;
    }
}
