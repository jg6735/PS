package PS_Level2.무인도여행;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
class Solution {
    // 방향 값
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public int[] solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()]; // 지도 배열
        boolean[][] visited = new boolean[map.length][maps[0].length()]; // 방문 체크용 배열
        List<Integer> list = new ArrayList<>(); // 정답 저장용 리스트

        // 지도 저장
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 바다가 아니고, 방문하지 않은 곳일 때
                if (map[i][j] != 'X' && !visited[i][j]) {
                    // bfs 최대 며칠씩 머물 수 있는지 리스트에 저장
                    int count = bfs(j, i, map, visited);
                    list.add(count);
                }
            }
        }

        // 리스트가 비어있다면 지낼 수 있는 무인도가 없는 것이므로 -1이 저장된 배열 반환
        if (list.isEmpty()) {
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        // 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }

    private static int bfs(int x, int y, char[][] map, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[y][x] = true;

        // 첫번째 무인도값 저장
        int count = map[y][x] - '0';
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                // 범위 벗어나면 pass
                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) {
                    continue;
                }

                // 다음 좌표가 방문하지 않았으면서 바다가 아니라면
                if (!visited[nextY][nextX] && map[nextY][nextX] != 'X') {
                    queue.offer(new Coordinate(nextX, nextY));
                    visited[nextY][nextX] = true;

                    // 다음 무인도값 더하기
                    count += map[nextY][nextX] - '0';
                }
            }
        }

        return count;
    }

    static class Coordinate {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}