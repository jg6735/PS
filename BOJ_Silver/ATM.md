# **ATM**
### π [BOJ S3 11399 ATM](https://www.acmicpc.net/problem/11399)
-------------
### **β νμ΄ κ³Όμ  / νμ΅ν λ΄μ©**
- μ΅μ μκ°μ κ΅¬ν΄μΌνλ κ·Έλ¦¬λν λ¬Έμ μλλ°, λ¨Όμ  μλ ₯ν λ°°μ΄μ μ λ ¬ν λ€μ μλ‘μ΄ λ°°μ΄μ λμ ν μκ°λ§νΌ λνμ¬ νμλ€.
-------------
### **μ½λ**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] res = new int[N];
		int answer = 0;
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		res[0] = arr[0];
		for (int i = 1; i < N; i++) {
			res[i] = res[i - 1] + arr[i];
		}
		
		for (int n : res) {
			answer += n;
		}
		
		System.out.println(answer);
	}

}
```