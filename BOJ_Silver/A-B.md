# **A -> B**
### π [BOJ S1 16953 A -> B](https://www.acmicpc.net/problem/16953)
-------------
### **β νμ΄ κ³Όμ  / νμ΅ν λ΄μ©**
- λ μλ¦¬κ° 1μ΄κ³  Bκ° 2λ‘ λλμ΄ λ¨μ΄μ§μ§ μμΌλ©΄ Aλ₯Ό λ§λ€ μ μμ΄ -1μ μΆλ ₯νκ³ ,
Bκ° 2μ λ°°μλ©΄ 2λ‘ λλκ³  2μ λ°°μκ° μλλ©΄ λ§¨ λμλ¦¬ 1μ μ§μ°κ³  μΉ΄μ΄ννλ€.
-------------
### **μ½λ**
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