# **RGB거리**
### 📌 [BOJ S1 1149 RGB거리](https://www.acmicpc.net/problem/1149)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 문제의 조건에서 인접하는 집의 색이 같으면 안됐기 때문에 
i번째 집에 색을 칠할 때 최소 비용 = i - 1번째 집에서 다른 색을 칠한 최소 비용 + 해당 색의 비용으로 식을 세우고 풀었다.   
처음에 집을 2차원배열로 저장하고 풀이하다 막혀서 오래 걸렸지만, 단순하게 각 집마다 최소비용을 구하면 되는 문제였다.
-------------
### **코드**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N + 1][3];
		int[] houses = new int[3];
		int answer = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			houses[0] = Integer.parseInt(st.nextToken()); // R
			houses[1] = Integer.parseInt(st.nextToken()); // G
			houses[2] = Integer.parseInt(st.nextToken()); // B
			
			// i번째 집에 조건에 맞는 색을 칠할 때 최소 비용 = i - 1번째 집에서 다른 색을 칠한 비용 + 빨간색 비용
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houses[0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houses[1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houses[2];
		}
		
		for (int i = 0; i < 3; i++) {
			answer = Math.min(dp[N][i], answer);
		}
		
		System.out.println(answer);
	}

}
```