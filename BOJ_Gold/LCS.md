# **LCS**
### ð [BOJ G5 9251 LCS](https://www.acmicpc.net/problem/9251)
-------------
### **â íì´ ê³¼ì  / íìµí ë´ì©**
- ìµì¥ ê³µíµ ë¶ë¶ ìì´ ë¬¸ì ìëë°, ìì íìì¼ë¡  ìëê³ , DPë¡ íì´ì¼ íë ë¬¸ì ìë¤. ë ë¬¸ìì´ì ë¬¸ìë¥¼ ë¹êµíë©´ì 
ê° ë¬¸ìì´ì ië²ì§¸ ë¬¸ìì jë²ì§¸ ë¬¸ìê° ê°ì¼ë©´ dp[i - 1][j - 1] ê¹ì§ì ê¸¸ì´ìì + 1ì í´ì£¼ë©° ì ì¥íë ìì¼ë¡ íìê³ , 
ië²ì§¸ ë¬¸ìì jë²ì§¸ ë¬¸ìê° ë¤ë¥´ë©´, ê°ê° ì´ì ê¹ì§ì ìµì¥ ê³µíµ ë¶ë¶ ìì´ ì¤ ìµëê°ì êµ¬íë ë°©ìì¼ë¡ íìë¤.
-------------
### **ì½ë 1**

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