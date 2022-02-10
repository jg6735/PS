package com.ssafy.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1번부터 N번까지 N명의 사람이 원을 이뤄 앉음.
 * 양의 정수 K(<= N)
 * 순서대로 K번째 사람 제거
 * 한 사람이 제거되면 남은 사람들도 이 과정 반복
 * N명의 사람이 모두 제거될 때 까지
 * <원에서 사람들이 제거되는 순서 출력>
 * ex: (N, K) - (7, 3) - <3, 6, 2, 7, 5, 1, 4>
 * 1, 2, 3, 4, 5, 6, 7  - 3
 * 4, 5, 6, 7, 1, 2 	- 6
 * 7, 1, 2, 4, 5		- 2
 * 4, 5, 7, 1			- 7
 * 1, 4, 5				- 5
 * 1, 4					- 1
 * 4					- 4
 * 
 * Array보다 Queue를 사용한 이유 ?
 * - FIFO (선입선출) 구조이기 때문에
 * - 삽입, 삭제가 많이 발생하기 때문에
 * 
 * (1) Queue를 생성한다.
 * (2) 원형을 이루므로 순서가 아닌 사람은 큐에서 빠져나와 큐에서 빠져나온 순서대로 다시 삽입한다.
 * (3) K번째 사람을 제거하기 위해 (2)를 K - 1번 반복한다.
 * (4) K번째 사람을 제거하면서 출력한다.
 */
public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// Queue에 번호 순서대로 삽입
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append('<');
		// Queue가 비어있지 않는 동안
		while (!queue.isEmpty()) {
			// K - 1번째 사람까지 Queue에서 삭제하고 삽입 반복
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		// ", "를 제거하기 위해 출력문 전체 길이 - 2
		sb.setLength(sb.length() - 2);
		sb.append('>');
		
		System.out.print(sb);
	}

}
