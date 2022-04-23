# **ATM**
### 📌 [BOJ S3 11399 ATM](https://www.acmicpc.net/problem/11399)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 최소 시간을 구해야하는 그리디한 문제였는데, 먼저 입력한 배열을 정렬한 뒤에 새로운 배열에 누적한 시간만큼 더하여 풀었다.
-------------
### **코드**
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