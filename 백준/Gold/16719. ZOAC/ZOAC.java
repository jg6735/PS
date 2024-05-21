import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        boolean[] isSelected = new boolean[arr.length];
        builder = new StringBuilder();

        recursion(arr, isSelected, 0, arr.length - 1);
        System.out.print(builder);
    }

    static void recursion(char[] arr, boolean[] isSelected, int left, int right) {
        if (left > right) {
            return;
        }

        int idx = left;
        for (int i = left; i <= right; i++) {
            if (arr[idx] > arr[i]) {
                idx = i;
            }
        }

        isSelected[idx] = true;
        for (int i = 0; i < arr.length; i++) {
            if (isSelected[i]) {
                builder.append(arr[i]);
            }
        }

        builder.append("\n");
        recursion(arr, isSelected, idx + 1, right);
        recursion(arr, isSelected, left, idx - 1);
    }
}