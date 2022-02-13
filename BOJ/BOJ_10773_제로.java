package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				stack.pop();
			} else {
				stack.push(N);
			}
		}
		
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		sb.append(sum);
		System.out.print(sb);
	}

}
