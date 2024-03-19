import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int R, C, K, answer = -1;
    private static int[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int cnt = -1;
        while (++cnt <= 100) {
            if (R < arr.length && C < arr[0].length && arr[R][C] == K) {
                answer = cnt;
                return;
            }

            findCount(arr.length, arr[0].length);
        }
    }

    private static void findCount(int rSize, int cSize) {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        if (rSize >= cSize) {
            arr = rowOperation(list, rSize, cSize);
        } else {
            arr = columnOperation(list, rSize, cSize);
        }
    }

    private static int[][] rowOperation(ArrayList<ArrayList<int[]>> list, int rSize, int cSize) {
        int[][] numbers = new int[rSize][101];
        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                if (arr[r][c] != 0) {
                    numbers[r][arr[r][c]]++;
                }
            }
        }

        int max = addListAndGetMax(list, rSize, numbers);
        sort(list);

        int[][] newArr = new int[rSize][max * 2];
        for (int r = 0; r < rSize; r++) {
            for (int i = 0, c = 0; c < list.get(r).size(); c++, i += 2) {
                int[] temp = list.get(r).get(c);
                newArr[r][i] = temp[0];
                newArr[r][i + 1] = temp[1];
            }
        }

        return newArr;
    }

    private static int[][] columnOperation(ArrayList<ArrayList<int[]>> list, int rSize, int cSize) {
        int[][] numbers = new int[cSize][101];
        for (int c = 0; c < cSize; c++) {
            for (int r = 0; r < rSize; r++) {
                if (arr[r][c] != 0) {
                    numbers[c][arr[r][c]]++;
                }
            }
        }

        int max = addListAndGetMax(list, cSize, numbers);
        sort(list);

        int[][] newArr = new int[max * 2][cSize];
        for (int c = 0; c < cSize; c++) {
            for (int r = 0, i = 0; r < list.get(c).size(); r++, i += 2) {
                int[] temp = list.get(c).get(r);
                newArr[i][c] = temp[0];
                newArr[i + 1][c] = temp[1];
            }
        }

        return newArr;
    }

    private static int addListAndGetMax(ArrayList<ArrayList<int[]>> list, int rSize, int[][] numbers) {
        int max = -1;
        for (int i = 0; i < rSize; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] != 0) {
                    list.get(i).add(new int[]{j, numbers[i][j]});
                }
            }

            max = Math.max(max, list.get(i).size());
        }
        
        return max;
    }

    private static void sort(ArrayList<ArrayList<int[]>> list) {
        for (ArrayList<int[]> arrayList : list) {
            arrayList.sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            });
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());
        arr = new int[3][3];
        for (int r = 0; r < 3; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < 3; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}