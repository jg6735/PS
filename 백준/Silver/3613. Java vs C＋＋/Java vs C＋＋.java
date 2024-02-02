import java.io.*;

public class Main {

    private static final String ERROR = "Error!";

    private static String input;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (!isCLang(input) && !isJavaLang(input)) {
            builder.append(ERROR);
            return;
        }

        char[] arr = input.toCharArray();
        if (isJavaLang(input)) {
            for (char c : arr) {
                if (Character.isUpperCase(c)) {
                    builder.append("_");
                }

                builder.append(Character.toLowerCase(c));
            }
        } else if (isCLang(input)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '_') {
                    builder.append(Character.toUpperCase(arr[++i]));
                } else {
                    builder.append(arr[i]);
                }
            }
        }
    }

    private static boolean isCLang(String input) {
        if (input.charAt(0) == '_' || input.charAt(input.length() - 1) == '_' || input.contains("__")) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isJavaLang(String input) {
        return !input.contains("_") && !Character.isUpperCase(input.charAt(0));
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        input = in.readLine();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}