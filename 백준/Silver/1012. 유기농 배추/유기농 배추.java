import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
	
	private static int M, N, K, count;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[Y][X] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(j, i);
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		visited[y][x] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int curX = cur.getX();
			int curY = cur.getY();
			
			for (int d = 0; d < 4; d++) {
				int nextX = curX + dx[d];
				int nextY = curY + dy[d];
				
				if (!check(nextX, nextY)) {
					continue;
				}
				
				if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
				}
			}
		}
	}
	
	private static boolean check(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N) {
			return false;
		}
		
		return true;
	}
}