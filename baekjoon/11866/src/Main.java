import java.io.*;
import java.util.*;

// Circular Queue 구현 문제

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            deque.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 0;
        while(deque.size() != 1) {
            count++;

            if(count == k) {

                sb.append(String.valueOf(deque.removeFirst()));
                sb.append(", ");

                count = 0;
            }
            else {
                deque.addLast(deque.removeFirst());
            }
        }

        sb.append(String.valueOf(deque.removeFirst()));
        sb.append(">");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}