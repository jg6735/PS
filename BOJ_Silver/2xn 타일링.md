# **2xn 타일링**
### 📌 [BOJ S3 2xn 타일링](https://www.acmicpc.net/problem/11726)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- DP를 이용해서 풀 수 있는 문제였다. 전에 풀었던 2xn 타일링 2번 문제랑 거의 흡사해서 빠르게 풀 수 있었다.
-------------
### **코드**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N + 1];
        
		dp[0] =1;
		dp[1]= 1;  
        
		for(int i = 2; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.print(dp[N]);
	}
}
```