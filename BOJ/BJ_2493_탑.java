package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 6 9 5 7 4   
 * 배열의 0번을 비워두고 인덱싱 하기 위해 arr[1] 부터 arr[N]까지 타워 높이 저장
 * 스택이 비어있으면 스택에 타워 번호를 저장
 * 스택이 비어있지 않고 i번째 타워의 높이가 현재 스택의 top보다 크면 스택의 top 인덱스에 i번 타워 저장하고 pop하기
 * 스택에 i번째 타워 push
 * 0 0 2 2 4
 */
public class BJ_2493_탑 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N + 1];
		int[] idx = new int[N + 1];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = N; i >= 1; i--) {
			if (stk.isEmpty()) {
				stk.push(i);
			} else {
				while(!stk.isEmpty() && arr[i] > arr[stk.peek()]) {
					idx[stk.peek()] = i;
					stk.pop();
				}
				
				stk.push(i);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(idx[i] + " ");
		}
		
		
		
	}

}
