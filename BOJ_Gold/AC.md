# **AC**
### 📌 [BOJ G5 5430 AC](https://www.acmicpc.net/problem/5430)
-------------
### **✔ 풀이 과정 / 학습한 내용**
- 배열을 직접 뒤집으면서 정렬하면 최악의 경우 O(N²)의 시간복잡도를 가지기 때문에 100,000까지의 input을 고려했을 때, 1초가 넘어간다.
- Deque 자료구조를 활용하면 쉽게 해결할 수 있다 !
  - 양방향 삽입, 삭제가 용이하다.
-------------
### **코드**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {

    private static int T, N, dir;
    private static boolean check;
    private static String P;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            deque = new ArrayDeque<>();

            P = in.readLine();
            N = Integer.parseInt(in.readLine());
            String array = in.readLine();
            array = array.substring(1, array.length() - 1);
            st = new StringTokenizer(array, ",");
            for (int i = 0; i < N; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            dir = 0;
            check = false;
            for (int i = 0; i < P.length(); ++i) {
                char cur = P.charAt(i);

                if (cur == 'R') {
                    dir = (dir + 1) % 2;
                } else if (cur == 'D') {
                    if (deque.isEmpty()) {
                        check = true;
                        break;
                    }

                    if (dir == 0) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (check) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (deque.size() > 1) {
                    if (dir == 0) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    sb.append(",");
                }

                if (deque.size() == 0) {
                    sb.append("]\n");
                } else {
                    sb.append(deque.pollFirst()).append("]\n");
                }
            }
        }

        System.out.print(sb);
    }
}
```
