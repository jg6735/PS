import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int SIZE = 5;

    private static int answer;
    private static char[] colors;
    private static int[] numbers;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(numbers);

        int colorCnt = 1;
        int numberCnt1 = 1;
        int number1 = 0;
        int numberCnt2 = 0;
        int number2 = 0;
        int maxNumber = numbers[0];
        int continualNumber = 1;
        for (int i = 0; i < SIZE - 1; i++) {
            if (colors[i] == colors[i + 1]) {
                colorCnt = Math.max(colorCnt, ++colorCnt);
            } else {
                colorCnt = 1;
            }

            if (numberCnt2 == 0 && numbers[i] == numbers[i + 1]) {
                numberCnt1 = Math.max(numberCnt1, ++numberCnt1);
                number1 = numbers[i];
            } else if (numberCnt2 == 0 && numbers[i] != numbers[i + 1]) {
                numberCnt2++;
            } else if (numberCnt2 != 0 && numbers[i] == numbers[i + 1]) {
                numberCnt2 = Math.max(numberCnt2, ++numberCnt2);
                number2 = numbers[i];
            }

            if (numbers[i] == numbers[i + 1] - 1) {
                continualNumber = Math.max(continualNumber, ++continualNumber);
            } else {
                continualNumber = 1;
            }

            maxNumber = Math.max(maxNumber, numbers[i + 1]);
        }

        if (colorCnt == 5 && continualNumber == 5) {
            answer = maxNumber + 900;
        } else if (numberCnt1 == 4) {
            answer = number1 + 800;
        } else if (numberCnt2 == 4) {
            answer = number2 + 800;
        } else if (numberCnt1 == 3 && numberCnt2 == 2) {
            answer = number1 * 10 + number2 + 700;
        } else if (numberCnt2 == 3 && numberCnt1 == 2) {
            answer = number2 * 10 + number1 + 700;
        } else if (colorCnt == 5) {
            answer = maxNumber + 600;
        } else if (continualNumber == 5) {
            answer = maxNumber + 500;
        } else if (numberCnt1 == 3) {
            answer = number1 + 400;
        } else if (numberCnt2 == 3) {
            answer = number2 + 400;
        } else if (numberCnt1 == 2 && numberCnt2 == 2) {
            answer = Math.max(number1, number2) * 10 + Math.min(number1, number2) + 300;
        } else if (numberCnt1 == 2) {
            answer = number1 + 200;
        } else if (numberCnt2 == 2) {
            answer = number2 + 200;
        } else {
            answer = maxNumber + 100;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        colors = new char[SIZE];
        numbers = new int[SIZE];
        StringTokenizer st;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(in.readLine());
            colors[i] = st.nextToken().charAt(0);
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}