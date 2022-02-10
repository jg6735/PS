package com.ssafy.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 100 x 100 크기의 배열을 생성
 * 2. 각 색종이의 좌표를 입력 받기
 * 3. 각 색종이의 면적에 해당하는 범위의 배열 요소를 1로 채우기
 * 4. 넓이 = 배열 요소가 1인 부분들의 합
 */
public class BOJ_2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[100][100];
		int N = Integer.parseInt(in.readLine());
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.print(sum);	
	}

}