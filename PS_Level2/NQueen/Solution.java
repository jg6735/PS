package PS_Level2.NQueen;

// https://school.programmers.co.kr/learn/courses/30/lessons/12952
class Solution {
    private static int[] col;
    private static int answer = 0;

    private static void setQueen(int rowNo, int n) {
        if (!isAvailable(rowNo - 1)) {
            return;
        }

        if (rowNo > n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            col[rowNo] = i;
            setQueen(rowNo + 1, n);
        }
    }

    private static boolean isAvailable(int rowNo) {
        for (int i = 1; i < rowNo; i++) {
            if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) {
                return false;
            }
        }

        return true;
    }

    public int solution(int n) {
        col = new int[n + 1];
        setQueen(1, n);
        return answer;
    }
}