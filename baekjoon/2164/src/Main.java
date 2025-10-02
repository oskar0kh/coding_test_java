import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }

        bw.write(String.valueOf(queue.poll()));

        bw.flush();
        bw.close();
    }
}