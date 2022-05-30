# **A -> B**
### 📌 [BOJ S1 16953 A -> B](https://www.acmicpc.net/problem/16953)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 끝 자리가 1이고 B가 2로 나누어 떨어지지 않으면 A를 만들 수 없어 -1을 출력하고,
B가 2의 배수면 2로 나누고 2의 배수가 아니면 맨 끝자리 1을 지우고 카운팅했다.
-------------
### **코드**
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
 
        int answer = 1;
        while (B != A) {
            if (B < A) {
                answer = -1;
                break;
            }
 
            String str = String.valueOf(B);
			
            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                answer = -1;
                break;
            }
 
            if (B % 2 == 0) {
                B >>= 1;
            } else {
                str = str.substring(0, str.length() - 1);
                B = Long.parseLong(str);
            }
 
            answer++;
        }
        
        System.out.println(answer);
    }
 
}
```