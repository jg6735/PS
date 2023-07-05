package PS_Level2.연속된부분수열의합;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        // 투포인터, 포인터간 길이, 누적합
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;

        while (end < sequence.length && start <= end) {
            // [0, 0]일 때, end 포인터의 값이 k일 때
            if (start == end) {
                sum = sequence[start];
            }

            if (sum == k) {
                // 현재 포인터간의 길이가 이전 것보다 더 짧으면
                if (end - start + 1 < length) {
                    length = end - start + 1;
                    answer[0] = start;
                    answer[1] = end;
                }

                // 다음 부분 수열의 합을 구하기 위해 start 포인터의 값을 누적합에서 뺀다.
                sum -= sequence[start];

                // end 포인터는 증가시켜 다음 누적합을 구한다.
                if (end + 1 < sequence.length) {
                    sum += sequence[end + 1];
                }

                // 두 포인터가 같으면 가장 짧은 경우
                if (start == end) {
                    break;
                }

                // 포인터 증가
                start++;
                end++;
            } else if (sum > k) {
                // 누적합이 더 크면 start 포인터를 이동시킨다.
                sum -= sequence[start++];
            } else {
                // 누적합이 더 작으면 end 포인터를 이동시킨다.
                if (end + 1 < sequence.length) {
                    sum += sequence[end + 1];
                }

                end++;
            }
        }

        return answer;
    }
}