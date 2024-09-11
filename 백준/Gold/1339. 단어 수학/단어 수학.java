import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int[] alphabets = new int[26];
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                int temp = (int) Math.pow(10, length - i - 1);
                alphabets[ch - 'A'] += temp;
            }
        }

        Integer[] arr = new Integer[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = alphabets[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int number = 9;
        int result = 0;
        for (int num : arr) {
            if (num == 0) {
                break;
            }

            result += num * number--;
        }

        System.out.print(result);
    }
}