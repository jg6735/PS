package PS_Level1.키패드누르기;

public class Solution {
    static class Hand {
        private int x;
        private int y;

        public Hand(int x, int y) {
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

    public String solution(int[] numbers, String hand) {
        StringBuilder builder = new StringBuilder();
        int[][] keyPad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {'*', 0, '#'}};
        Hand leftHand = new Hand(3, 0);
        Hand rightHand = new Hand(3, 2);

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            for (int j = 0; j < keyPad.length; j++) {
                if (number == keyPad[j][0]) { // 왼쪽 열의 숫자를 입력하는 경우
                    leftHand.move(j, 0);
                    builder.append("L");
                    break;
                } else if (number == keyPad[j][2]) { // 오른쪽 열의 숫자를 입력하는 경우
                    rightHand.move(j, 2);
                    builder.append("R");
                    break;
                } else if (number == keyPad[j][1]) { // 가운데 열의 숫자를 입력하는 경우
                    int leftHandDistance = getDistance(leftHand.getX(), leftHand.getY(), j, 1);
                    int rightHandDistance = getDistance(rightHand.getX(), rightHand.getY(), j, 1);

                    // 각 손의 거리 비교
                    if (leftHandDistance < rightHandDistance) {
                        leftHand.move(j, 1);
                        builder.append("L");
                    } else if (rightHandDistance < leftHandDistance) {
                        rightHand.move(j, 1);
                        builder.append("R");
                    } else {
                        if (hand.equals("left")) {
                            leftHand.move(j, 1);
                            builder.append("L");
                        } else {
                            rightHand.move(j, 1);
                            builder.append("R");
                        }
                    }

                    break;
                }
            }
        }

        return builder.toString();
    }

    // 키패드 이동 한 칸의 거리는 1이므로 각 좌표간의 차이를 통해 거리 계산하는 메서드
    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
