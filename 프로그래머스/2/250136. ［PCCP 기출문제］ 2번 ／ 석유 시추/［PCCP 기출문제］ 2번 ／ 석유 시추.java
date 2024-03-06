import java.util.*;

class Solution {
    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0 ,-1};
    
    private static int[] arr;
    
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        arr = new int[land[0].length];
        
        for (int c = 0; c < land[0].length; c++) {
            int sum = 0;
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    bfs(land, r, c, visited);
                }
            }
        }
        
        int answer = 0;
        for (int result : arr) {
            answer = Math.max(answer, result);
        }
        
        return answer;
    }

    private void bfs(int[][] land, int r, int c, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;
        
        Coordinate cur;
        int curR, curC, nextR, nextC, count = 1;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();
            set.add(curC);
            
            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];
                
                if (canVisit(land, nextR, nextC) && !visited[nextR][nextC] && land[nextR][nextC] == 1) {
                    queue.add(new Coordinate(nextR, nextC));
                    visited[nextR][nextC] = true;
                    count++;
                } 
            }
        }
        
        for (int idx : set) {
            arr[idx] += count;
        }
    }
    
    private boolean canVisit(int[][] land, int r, int c) {
        return r >= 0 && c >= 0 && r < land.length && c < land[r].length;
    }
}

class Coordinate {
    private final int r;
    private final int c;
    
    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    public int getR() {
        return r;
    }
    
    public int getC() {
        return c;
    }
}