# **RGB๊ฑฐ๋ฆฌ**
### ๐ [BOJ S1 1149 RGB๊ฑฐ๋ฆฌ](https://www.acmicpc.net/problem/1149)
-------------
### **โ ํ์ด ๊ณผ์  / ํ์ตํ ๋ด์ฉ**
- ๋ฌธ์ ์ ์กฐ๊ฑด์์ ์ธ์ ํ๋ ์ง์ ์์ด ๊ฐ์ผ๋ฉด ์๋๊ธฐ ๋๋ฌธ์ 
i๋ฒ์งธ ์ง์ ์์ ์น ํ  ๋ ์ต์ ๋น์ฉ = i - 1๋ฒ์งธ ์ง์์ ๋ค๋ฅธ ์์ ์น ํ ์ต์ ๋น์ฉ + ํด๋น ์์ ๋น์ฉ์ผ๋ก ์์ ์ธ์ฐ๊ณ  ํ์๋ค.   
์ฒ์์ ์ง์ 2์ฐจ์๋ฐฐ์ด๋ก ์ ์ฅํ๊ณ  ํ์ดํ๋ค ๋งํ์ ์ค๋ ๊ฑธ๋ ธ์ง๋ง, ๋จ์ํ๊ฒ ๊ฐ ์ง๋ง๋ค ์ต์๋น์ฉ์ ๊ตฌํ๋ฉด ๋๋ ๋ฌธ์ ์๋ค.
-------------
### **์ฝ๋**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB๊ฑฐ๋ฆฌ {

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