import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ G2 3109 빵집
 * https://www.acmicpc.net/problem/3109
 * 백트래킹
 * 
 */
public class BOJ_3109_빵집 {

	static int R, C, max, count;
	static char[][] arr;
	static boolean[][] visited;
	// 방향값 - 우상, 우, 우하 순서
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C]; // 격자 배열
		visited = new boolean[R][C]; // 방문 체크
		count = 0; // 파이프라인의 개수

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 첫째 열에서만 시작해야 하므로 각 행의 첫번째에서 시작
		for (int i = 0; i < R; i++) {
			// 각 행마다 파이프를 빵집까지 완성할수 있으면 개수 증가
			if (solve(i, 0)) {
				count++;
			}
		}

		sb.append(count);
		System.out.print(sb);
	}

	// dfs
	public static boolean solve(int x, int y) {
		// 방문 체크
		visited[x][y] = true;

		// 마지막 열에 도착하면 파이프 완성!
		if (y == C - 1) {
			return true;
		}

		for (int d = 0; d < 3; d++) {

			int nx = x + dx[d];
			int ny = y + dy[d];

			// 파이프를 놓을 수 있는지 체크
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}

			// 다음 장소에 건물이 있거나 이미 지나갔던 장소라면 pass
			if (arr[nx][ny] == 'x' || visited[nx][ny]) {
				continue;
			}

			// 다음 자리에 파이프를 놓을 수 있으면
			if (solve(nx, ny)) {
				return true;
			}
		}

		return false;
	}

//	// 파이프를 놓을 수 있는지 체크
//	public static boolean isAvailable(int x, int y, char[][] arr) {
//
//		// 범위 바깥을 벗어나면 pass
//		if (x < 0 || y < 0 || x >= R || y >= C) {
//			return false;
//		}
//		
//		// 다음 장소에 건물이 있거나 이미 지나갔던 장소라면 pass
//		if (arr[x][y] == 'x' || visited[x][y]) {
//			return false;
//		}
//
//		return true;
//	}
}
