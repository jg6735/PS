package PS_Level2.방문길이;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994
class Solution {
    static class Player {
        private int x;
        private int y;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // U, R, D, L
    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {-1, 0, 1, 0};

    // 0 -> U, 1 -> R, 2 -> D, 3 -> L
    private static int getDirection(char c) {
        switch (c) {
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
            case 'U':
            default:
                return 0;
        }
    }

    // 다음 좌표로 움직일 수 있는지?
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    public int solution(String dirs) {
        int answer = 0;

        Player player = new Player(5, 5);
        int[][][] map = new int[11][11][4];
        int curX, curY, nextX, nextY;
        for (int i = 0; i < dirs.length(); i++) {
            // 방향과 다음 좌표 구하기
            int direction = getDirection(dirs.charAt(i));
            curX = player.getX();
            curY = player.getY();
            nextX = curX + dx[direction];
            nextY = curY + dy[direction];

            if (!isAvailable(nextX, nextY)) {
                continue;
            }

            // 현재 좌표에서 움직인 방향 체크하고 이동
            map[curY][curX][direction]++;
            player.move(nextX, nextY);

            // 한 번만 걸어본 길 구하기
            if (map[curY][curX][direction] == 1 && map[nextY][nextX][(direction + 2) % 4] == 0) {
                answer++;
            }
        }

        return answer;
    }
}