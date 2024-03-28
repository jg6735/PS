import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            
            return o1[col - 1] - o2[col - 1];
        });
        
        int result = 0;
        for (int r = row_begin - 1; r < row_end; r++) {
            int sum = 0;
            for (int c = 0; c < data[r].length; c++) {
                sum += data[r][c] % (r + 1);
            }

            result = result ^ sum;
        }
        
        return result;
    }
}