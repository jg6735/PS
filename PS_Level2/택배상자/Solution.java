package PS_Level2.택배상자;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704
class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        int boxNumber = 1; // 택배상자 번호
        int orderIndex = 0; // 원하는 택배상자 번호
        while (true) {
            // 컨베이어 벨트 끝까지 돌고난 이후에
            if (boxNumber > order.length) {
                // 보조 컨베이어 벨트가 비어있거나 원하는 상자가 맨 앞에 없는 경우 종료
                if (deque.isEmpty() || orderIndex == order.length || deque.peek() != order[orderIndex]) {
                    break;
                }

                deque.pop();
                answer++;
                orderIndex++;
            }

            // 원하는 택배상자의 번호와 컨베이버 벨트의 택배상자 번호가 같은 경우 상자 싣기
            if (order[orderIndex] == boxNumber) {
                answer++;
                boxNumber++;
                orderIndex++;
            // 원하는 택배상자의 번호와 보조 컨베이버 벨트의 택배상자 번호가 같은 경우 상자 싣기
            } else if (!deque.isEmpty() && deque.peek() == order[orderIndex]) {
                deque.pop();
                answer++;
                boxNumber++;
                orderIndex++;
            // 해당 사항 없는 경우 컨베이버 벨트의 다음 상자 받기
            } else {
                deque.push(boxNumber++);
            }
        }

        return answer;
    }
}