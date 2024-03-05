class Solution {
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] array = init(rows, columns);
        
        int startR, startC, endR, endC, idx = 0;
        for (int[] query : queries) {
            startR = query[0] - 1;
            startC = query[1] - 1;
            endR = query[2] - 1;
            endC = query[3] - 1;
            answer[idx++] = rotate(array, startR, startC, endR, endC);
        }
        
        return answer;
    }
    
    private int rotate(int[][] array, int startR, int startC, int endR, int endC) {
        int temp = array[startR][startC];
        int r = startR;
        int c = startC;
        int d = 0;
        int min = temp;
        while (true) {
            min = Math.min(min, array[r][c]);
            int nextR = r + DR[d];
            int nextC = c + DC[d];
            
            if (nextR >= startR && nextC >= startC && nextR <= endR && nextC <= endC) {
                array[r][c] = array[nextR][nextC];
            } else {
                d++;
                continue;
            }
            
            if (nextR == startR && nextC == startC) {
                array[r][c] = temp;
                break;
            }
            
            r = nextR;
            c = nextC;
        }
        
        return min;
    }
    
    private int[][] init(int row, int col) {
        int[][] array = new int[row][col];
        
        int start = 1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                array[r][c] = start++;
            }
        }
        
        return array;
    }
}