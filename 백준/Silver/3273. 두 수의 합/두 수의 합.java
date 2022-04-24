import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3273
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(in.readLine());
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = n - 1;
		int count = 0;
		int sum = 0;
		
		while (start < end) {
			sum = arr[start] + arr[end];
			
			if (sum == x) {
				count++;
			}
			
			if (sum <= x) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(count);
	}

}