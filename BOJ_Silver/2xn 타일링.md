# **2xn νμΌλ§**
### π [BOJ S3 2xn νμΌλ§](https://www.acmicpc.net/problem/11726)
-------------
### **β νμ΄ κ³Όμ  / νμ΅ν λ΄μ©**
- DPλ₯Ό μ΄μ©ν΄μ ν μ μλ λ¬Έμ μλ€. μ μ νμλ 2xn νμΌλ§ 2λ² λ¬Έμ λ κ±°μ ν‘μ¬ν΄μ λΉ λ₯΄κ² ν μ μμλ€.
-------------
### **μ½λ**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xnνμΌλ§ {

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