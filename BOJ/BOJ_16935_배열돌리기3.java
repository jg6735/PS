package com.ssafy.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int R = Integer.parseInt(st.nextToken()); // 연산 횟수
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0, O; i < R; i++) {
			O = Integer.parseInt(st.nextToken());
			
			switch (O) {
			case 1 :
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			}
		}
		
		print();
			
	}
	
	// 상하 반전
	static void rotate1() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = arr[r - i - 1][j];
			}
		}
		
		arr = temp;
	}
	
	// 좌우 반전
	static void rotate2() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = arr[i][c - j - 1];
			}
		}
		
		arr = temp;
		
	}
	
	// 오른쪽으로 90도 회전
	static void rotate3() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[c][r];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[j][r - 1 - i] = arr[i][j];
			}
		}

		arr = temp;
	}
	
	// 왼쪽으로 90도 회전
	static void rotate4() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[c][r];
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = arr[j][temp.length - i - 1];
			}
		}
		
		arr = temp;
	}
	
	// 부분 이동 시계방향
	static void rotate5() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];
		
		// 1 <-> 2 그룹 스왑
		for (int i = 0; i < r / 2; i++) {
			for (int j = 0; j < c / 2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[i][c / 2 + j];
				arr[i][c / 2 + j] = temp[i][j];
			}
		}
		
		// 4 <-> 3 그룹 스왑
		for (int i = r / 2; i < r; i++) {
			for (int j = 0; j < c / 2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[i][c / 2 + j];
				arr[i][c / 2 + j] = temp[i][j];
			}
		}
		
		// 1 <-> 3 그룹 스왑(2와 4가 바뀜)
		/* 4 1
		 * 3 2
		 */
		for (int i = 0; i < r / 2; i++) {
			for (int j = 0; j < c / 2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[r / 2 + i][c / 2 + j];
				arr[r / 2 + i][c / 2 + j] = temp[i][j];
			}
		}
	}
	
	// 부분 이동 반시계방향
	static void rotate6() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];

		// 1 <-> 4 그룹 스왑
		for (int i = 0; i < r / 2; i++) {
			for (int j = 0; j < c / 2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[r / 2 + i][j];
				arr[r / 2 + i][j] = temp[i][j];
			}
		}
		
		// 2 <-> 3 그룹 스왑
		for (int i = 0; i < r / 2; i++) {
			for (int j = c / 2; j < c; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[r / 2 + i][j];
				arr[r / 2 + i][j] = temp[i][j];
			}
		}
		
		// 1 <-> 3 그룹 스왑(4와 2가 바뀜)
		/* 2 3
		 * 1 4
		 */
		for (int i = 0; i < r / 2; i++) {
			for (int j = 0; j < c / 2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[r / 2 + i][c / 2 + j];
				arr[r / 2 + i][c / 2 + j] = temp[i][j];
			}
		}
	}
	
	// 출력
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
