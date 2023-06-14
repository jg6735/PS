package PS_Level2.교점에서별만들기;

/*
- 문제 풀이 흐름
1. 모든 직선 쌍에 대해 반복하기
    A. 교점 좌표 구하기
    B. 정수 좌표만 저장하기
2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정하기
4. 2차원 배열에 별 표시하기
5. 문자열 배열로 변환 후 반환하기
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static class Point {
        private final long x, y; // 데이터를 나타내는 클래스이므로 final 키워드로 불변성 갖기
        // 문제에서 좌표 범위가 주어지지 않았기 때문에 long 으로 표현하기

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }

    // 교점의 좌표 구하는 메서드
    /*
    Ax + By + E = 0, Cx + Dy + F = 0 일때,
    x = (BF - ED) / (AD - BC), y = (EC - AF) / (AD - BC)
    AD - BC = 0 인 경우, 평행 or 일치하는 직선
     */
    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    private static Point getMinimumPoint(List<Point> points) {
        // 가장 작은 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.getX() < x) {
                x = p.getX();
            }

            if (p.getY() < y) {
                y = p.getY();
            }
        }

        return new Point(x, y);
    }

    private static Point getMaximumPoint(List<Point> points) {
        // 가장 큰 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.getX() > x) {
                x = p.getX();
            }

            if (p.getY() > y) {
                y = p.getY();
            }
        }

        return new Point(x, y);
    }

    public static String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 정수 좌표만 저장하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]
                );

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 최댓값, 최솟값을 이용해 2차원 배열의 크기 결정하기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int) (maximum.getX() - minimum.getX() + 1);
        int height = (int) (maximum.getY() - minimum.getY() + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 2차원 배열에 별 찍기
        for (Point p : points) {
            // 2차원 배열에서 (0, 0)은 실제 교점의 (0, 0)이 아니기 때문에 좌표 변환시켜주기
            int x = (int) (p.getX() - minimum.getX());
            int y = (int) (maximum.getY() - p.getY());
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
}
