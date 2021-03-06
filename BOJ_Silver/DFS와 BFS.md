# **DFS์ BFS**
### ๐ [BOJ S2 1260 DFS์ BFS](https://www.acmicpc.net/problem/1260)
-------------
### **โ ํ์ด ๊ณผ์  / ํ์ตํ ๋ด์ฉ**
- ์ฃผ์ด์ง ๋ฌดํฅ ๊ทธ๋ํ๋ฅผ DFS์ BFS๋ฅผ ์ด์ฉํด ํ์ํ ์ง์ ์ ์ถ๋ ฅํ๋ ๋ฌธ์ ์๋ค.     
๋ฌดํฅ ๊ทธ๋ํ์ด๊ธฐ ๋๋ฌธ์ ๊ฐ์  ํ๋๋ก ์๋ฐฉํฅ ์ฒ๋ฆฌ๋ฅผ ํด์ฃผ๊ณ  ํ์์ ํ๋ค.   
๊ธฐ์กด์ ํธ๋ฆฌ์์๋ BFS์์ ๋ฐฉ๋ฌธ ๊ด๋ฆฌ๋ฅผ ํ์ง ์์์ง๋ง   
๊ทธ๋ํ์์์ BFS๋ ๋ฐฉ๋ฌธ ๊ด๋ฆฌ๋ฅผ ํด์ฃผ์ด์ผ ๊ฐ์ ์ ์ ์ ์ฌ๋ฌ๋ฒ ๋ฐฉ๋ฌธํ๋ ๊ฒฝ์ฐ๊ฐ ์๊ธฐ์ง ์์๋ค! 
-------------
### **์ฝ๋**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS์BFS {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ์ ์ ์ ๊ฐ์
		int M = Integer.parseInt(st.nextToken()); // ๊ฐ์ ์ ๊ฐ์
		int V = Integer.parseInt(st.nextToken()); // ํ์์ ์์ํ  ์ ์ 
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			// ๋ฌดํฅ์ด๋ฏ๋ก ๊ฐ์  ํ๋๋ก ์๋ฐฉํฅ ์ฒ๋ฆฌ
			graph[from][to] = graph[to][from] = 1;
		}
		
		dfs(graph, new boolean[N + 1], V, N);
		sb.append("\n");
		bfs(graph, new boolean[N + 1], V, N);
		System.out.print(sb);
		
	}

	public static void dfs(int[][] graph, boolean[] visited, int current, int N) {
		visited[current] = true;
		sb.append(current).append(" ");

		// current ์ ์ ์ ๋ฐฉ๋ฌธํ์ง ์์ ์ธ์ ์ ์  ์ฒ๋ฆฌ
		for (int i = 1; i <= N; i++) {
			// ๋ฐฉ๋ฌธํ์ง ์์ ์ ์ ์ด๊ณ , ํ์ฌ ์ ์ ์์ i ์ ์ ์ผ๋ก ๊ฐ ์ ์๋ค๋ฉด
			if (!visited[i] && graph[current][i] != 0) {
				dfs(graph, visited, i, N);
			}
		}
	}
	
	public static void bfs(int[][] graph, boolean[] visited, int start, int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start); // ํ์ํ  ์ ์  ๋ฃ๊ธฐ
		visited[start] = true; // ํ์ ๋ค์ด๊ฐ ๋ ๋ฐฉ๋ฌธ ์ฒดํฌ
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			// current ์ ์ ์ ๋ฐฉ๋ฌธํ์ง ์์ ์ธ์  ์ ์  ์ฒ๋ฆฌ
			for (int i = 1; i <= N; i++) {
				// ๋ฐฉ๋ฌธํ์ง ์์ ์ ์ ์ด๊ณ , ํ์ฌ ์ ์ ์์ i ์ ์ ์ผ๋ก ๊ฐ ์ ์๋ค๋ฉด
				if (!visited[i] && graph[current][i] != 0) {
					// ํ์ i์ ์ ์ ๋ค์ ํ์ ์์๋ก ์ง์ด ๋ฃ๊ณ 
					queue.offer(i);
					// ๋ฐฉ๋ฌธ ์ฒดํฌ
					visited[i] = true;
				}
			}
		}
	}
}
```