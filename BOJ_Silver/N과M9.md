# **N๊ณผ M (9)**
### ๐ [BOJ S2 N๊ณผ M(9)](https://www.acmicpc.net/problem/15663)
-------------
### **โ ํ์ด ๊ณผ์  / ํ์ตํ ๋ด์ฉ**
- ์์ด ๋ฌธ์ ์ธ๋ฐ, ์ด์  N๊ณผ M ๋ฌธ์ ์๋ ๋ฌ๋ฆฌ ๋์ผํ ์์ด์ ์ฌ๋ฌ๋ฒ ์ถ๋ ฅํ๋ฉด ์๋๋ค.   
๊ทธ๋์ ๋ฐฑํธ๋ํน์ ํตํด ์ค๋ณต์ ์ ๊ฑฐํ๋ค. ๊ทธ ๊ณผ์ ์์ ์กฐ๊ฑด์ ์ฐพ๋ ๊ฒ์ด ์ฝ๊ฐ ์ด๋ ค์ ๋ค.   
๋ ๋ค๋ฅธ ํด๊ฒฐ ๋ฐฉ๋ฒ์ผ๋ก๋ ๊ฐ์ ์์์ ์ค๋ณต์ ํ์ฉํ์ง ์๋ Set ์ปฌ๋ ์์ ์ด์ฉํ๋ฉด ๋ ์ฝ๊ฒ ํ ์ ์๊ฒ ๋ค๋ ์๊ฐ์ด ๋ค์๋ค.
-------------
**์ฝ๋**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663_N๊ณผM9 {

	static int N, M;
	static int[] numbers;
	static int[] result;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		result = new int[M];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		perm(0);
		System.out.print(sb);
	}
	
	public static void perm(int cnt) {
		
		// ๊ธฐ์ ์กฐ๊ฑด
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// ์ค๋ณต์ ์ ๊ฑฐํ๊ธฐ ์ํด ์ง์ด๋ฃ์๋ ๊ฐ์ ์ ์ฅํ๋ ๋ณ์
		int n = 0;
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}
			
			if (i != 0 && n == numbers[i]) {
				continue;
			}
			
			n = numbers[i];
			
			isSelected[i] = true;
			result[cnt] = numbers[i];
			perm(cnt + 1);
			isSelected[i] = false;
			
		}
	}

}
```