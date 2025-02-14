import java.util.*;

class Solution {
    
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, 1, 0, -1};
    
    private int n, m;
    private char[][] arr;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            arr[i] = storage[i].toCharArray();
        }
        
        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 1) {
                removeOutside(c);
            } else {
                removeBoth(c);
            }
        }

        return countContainers();
    }

    private void removeOutside(char c) {
        boolean[][] outside = findOutside();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == c && outside[i][j]) {
                    arr[i][j] = '.';
                }
            }
        }
    }
    
    private void removeBoth(char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == c) {
                    arr[i][j] = '.';
                }
            }
        }
    }
    
    private int countContainers() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '.') {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean[][] findOutside() {
        boolean[][] outside = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && arr[i][j] == '.') {
                    outside[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nextR = curR + dr[d];
                int nextC = curC + dc[d];
                
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
                    continue;
                }
                
                if (outside[nextR][nextC]) {
                    continue;
                }
                
                if (arr[nextR][nextC] == '.') {
                    outside[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }

        boolean[][] result = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (arr[r][c] != '.') {
                    if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                        result[r][c] = true;
                    } else {
                        for (int d = 0; d < 4; d++) {
                            int nextR = r + dr[d];
                            int nextC = c + dc[d];
                            
                            if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && outside[nextR][nextC]) {
                                result[r][c] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}