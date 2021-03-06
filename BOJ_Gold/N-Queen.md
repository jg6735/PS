# **N-Queen**
### π [BOJ G5 9663 N-Queen(https://www.acmicpc.net/problem/9663)
-------------
### **β νμ΄ κ³Όμ  / νμ΅ν λ΄μ©**
- N-Queen λ¬Έμ λ ν¬κΈ°κ° N x NμΈ μ²΄μ€ν μμ νΈ Nκ°λ₯Ό μλ‘ κ³΅κ²©ν  μ μκ² λλ λ¬Έμ μ΄λ€.
μ²«λ²μ§Έ μ½λλ 1μ΄λΆν° Nμ΄κΉμ§ νΈμ λμλ³΄κ³ , λμμ§ λ§μ§λ§ νΈμ μμΉλ₯Ό λΉκ΅νλ©° λμ μ μλ μλ¦¬λ©΄ λ¦¬ν΄νλλ‘ νλ€.   
λλ²μ§Έ μ½λλ μ μ΄μ νΈμ λμ λ, λμ μ μλ μλ¦¬μΌ λλ§ λλλ‘ νλ€.
μνμκ°μ λκΈ° μ μ κ³ λ €νλ λλ²μ§Έ μ½λκ° λ μ§§μμ‘λ€.    
μ΄λ€ λ°©λ²μΌλ‘ λ ν¨μ¨μ μΌλ‘ μνν  μ μμμ§ κ³ λ―Όν΄λ΄μΌκ² λ€.
-------------
### **μ½λ 1**

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

### **μ½λ 2**
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