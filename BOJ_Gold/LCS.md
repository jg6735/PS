# **LCS**
### 📌 [BOJ G5 9251 LCS(https://www.acmicpc.net/problem/9251)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 최장 공통 부분 수열 문제였는데, 완전탐색으론 안되고, DP로 풀어야 하는 문제였다. 두 문자열의 문자를 비교하면서 
각 문자열의 i번째 문자와 j번째 문자가 같으면 dp[i - 1][j - 1] 까지의 길이에서 + 1을 해주며 저장하는 식으로 풀었고, 
i번째 문자와 j번째 문자가 다르면, 각각 이전까지의 최장 공통 부분 수열 중 최댓값을 구하는 방식으로 풀었다.
-------------
### **코드 1**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
        
        int a = str1.length();
        int b = str2.length();
		
        int[][] dp = new int[a + 1][b + 1];
        
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        System.out.print(dp[a][b]);
	}
}
```