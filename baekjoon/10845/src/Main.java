import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push")) {
                deque.offerLast(st.nextToken());
            }
            else if(cmd.equals("pop")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.poll() + "\n");
            }
            else if(cmd.equals("size")) {
                bw.write(deque.size() + "\n");
            }
            else if(cmd.equals("empty")) {
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(cmd.equals("front")) {
                if (deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.getFirst() + "\n");
            }
            else if(cmd.equals("back")) {
                if (deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.getLast() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}