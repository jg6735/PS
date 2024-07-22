// https://school.programmers.co.kr/learn/courses/30/lessons/68936
class Solution {
    public int[] solution(int[][] arr) {
        Count recursion = recursion(0, 0, arr.length, arr);
        return new int[]{recursion.getZeros(), recursion.getOnes()};
    }

    private static Count recursion(int x, int y, int size, int[][] arr) {
        int h = size / 2;

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                // 다른 값을 만나면 분할
                if (arr[i][j] != arr[y][x]) {
                    return recursion(x, y, h, arr)
                            .add(recursion(x + h, y, h, arr))
                            .add(recursion(x, y + h, h, arr))
                            .add(recursion(x + h, y + h, h, arr));
                }
            }
        }

        // 기저 조건 : 모든 값이 1 또는 0인 경우
        if (arr[y][x] == 1) {
            return new Count(0, 1);
        }

        return new Count(1, 0);
    }

    private static class Count {
        private final int zeros;
        private final int ones;

        public Count(int zeros, int ones) {
            this.zeros = zeros;
            this.ones = ones;
        }

        public int getZeros() {
            return zeros;
        }

        public int getOnes() {
            return ones;
        }

        public Count add(Count count) {
            return new Count(zeros + count.getZeros(), ones + count.getOnes());
        }
    }
}