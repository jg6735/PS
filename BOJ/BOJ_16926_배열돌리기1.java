package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 - https://www.acmicpc.net/problem/16926
 */

/*
 * 시간초과, FAIL
 * java.lang.System
 * >> 시간관련 메서드 (currentTimeMillis(), nanoTime())
 * >> 수행시간 (실행시간)
 * >> System.nanoTime() : long
 * long time = System.nanoTime();
 * double execTime = time / 1000000000.0 - 로직의 시간 체크
 */
public class BOJ_16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int s = Math.min(N, M);
		
		int[][] arr = new int[N][M];
		// 우, 하, 좌, 상 순서로
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// R번 회전
		for (int t = 0; t < R; t++) { // 회전 횟수 R만큼 반복
			for (int i = 0; i < s / 2; i++) { // 짧은 배열 길이 부분을 2로 나눈 만큼 반복
				int r = i;
				int c = i;
				int temp = arr[r][c]; // temp에 시작지점의 값을 저장
				int dir = 0;
				
				while (dir < 4) {
					int nr = r + dx[dir];
					int nc = c + dy[dir];

					// 해당 사각형의 벽을 만나면 방향 변경
					if(nr < i || nc < i || nr > N - i - 1 || nc > M - i - 1) {
						dir++;					
					} else { // 아니라면 
						arr[r][c] = arr[nr][nc];
						r = nr;
						c = nc;
					}
				}
				// 시작지점의 값을 다음행에 저장
				arr[r + 1][c] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

}
