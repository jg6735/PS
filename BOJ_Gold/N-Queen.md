# **N-Queen**
### 📌 [BOJ G5 9663 N-Queen(https://www.acmicpc.net/problem/9663)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- N-Queen 문제는 크기가 N x N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
첫번째 코드는 1열부터 N열까지 퀸을 놓아보고, 놓아진 마지막 퀸의 위치를 비교하며 놓을 수 없는 자리면 리턴하도록 했다.
두번째 코드는 애초에 퀸을 놓을 때, 놓을 수 있는 자리일 때만 놓도록 했다.
수행시간은 놓기 전에 고려하는 두번째 코드가 더 짧아졌다. 어떤 방법으로 더 효율적으로 수행할 수 있을지 고민해봐야겠다.
-------------
### **코드 1**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQUEEN {

	private static int N, ans;
	private static int[] col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ans = 0;
		col = new int[N + 1];
		setQueen(1);
		System.out.println(ans);
	}
	
	private static void setQueen(int rowNo) {
		
		if (!isAvailable(rowNo - 1)) {
			return;
		}

		if (rowNo > N) {
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueen(rowNo + 1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		
		for (int i = 1; i < rowNo; i++) {
			if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) {
				return false;
			}
		}
		return true;
		
	}
}
```

### **코드 1**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N, ans;
	private static int[] col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ans = 0;
		col = new int[N + 1];
		setQueen(1);
		System.out.println(ans);
	}
	
	private static void setQueen(int rowNo) {
		if (rowNo > N) {
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			if (isAvailable(rowNo)) {
				setQueen(rowNo + 1);
			}
		}
	}

	private static boolean isAvailable(int rowNo) {
		
		for (int i = 1; i < rowNo; i++) {
			if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) {
				return false;
			}
		}
		return true;
		
	}
}
```