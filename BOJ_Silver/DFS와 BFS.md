# **DFS와 BFS**
### 📌 [BOJ S2 1260 DFS와 BFS](https://www.acmicpc.net/problem/1260)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 주어진 무향 그래프를 DFS와 BFS를 이용해 탐색한 지점을 출력하는 문제였다.     
무향 그래프이기 때문에 간선 하나로 양방향 처리를 해주고 탐색을 했다.   
기존에 트리에서는 BFS시에 방문 관리를 하지 않았지만   
그래프에서의 BFS는 방문 관리를 해주어야 같은 정점을 여러번 방문하는 경우가 생기지 않았다! 
-------------
### **코드**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			// 무향이므로 간선 하나로 양방향 처리
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

		// current 정점의 방문하지 않은 인접정점 처리
		for (int i = 1; i <= N; i++) {
			// 방문하지 않은 정점이고, 현재 정점에서 i 정점으로 갈 수 있다면
			if (!visited[i] && graph[current][i] != 0) {
				dfs(graph, visited, i, N);
			}
		}
	}
	
	public static void bfs(int[][] graph, boolean[] visited, int start, int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start); // 탐색할 정점 넣기
		visited[start] = true; // 큐에 들어갈 때 방문 체크
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			// current 정점의 방문하지 않은 인접 정점 처리
			for (int i = 1; i <= N; i++) {
				// 방문하지 않은 정점이고, 현재 정점에서 i 정점으로 갈 수 있다면
				if (!visited[i] && graph[current][i] != 0) {
					// 큐에 i정점을 다음 탐색 순서로 집어 넣고
					queue.offer(i);
					// 방문 체크
					visited[i] = true;
				}
			}
		}
	}
}
```