# **N과 M (9)**
### 📌 [BOJ S2 N과 M(9)](https://www.acmicpc.net/problem/15663)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 순열 문제인데, 이전 N과 M 문제와는 달리 동일한 수열을 여러번 출력하면 안된다.   
그래서 백트래킹을 통해 중복을 제거했다. 그 과정에서 조건을 찾는 것이 약간 어려웠다.   
또 다른 해결 방법으로는 같은 요소의 중복을 허용하지 않는 Set 컬렉션을 이용하면 더 쉽게 풀 수 있겠다는 생각이 들었다.
-------------
**코드**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663_N과M9 {

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
		
		// 기저조건
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 중복을 제거하기 위해 집어넣었던 값을 저장하는 변수
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