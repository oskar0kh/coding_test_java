import java.io.*;
import java.util.PriorityQueue;

// 최소 힙 (Min Heap) 구현 : 그냥 PriorityQueue 사용

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // pQ는 기본적으로 최소 힙

        int n = Integer.parseInt(T.br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(T.br.readLine());

            if(x!=0) {
                pQ.offer(x);
            }
            else if(x==0 && pQ.isEmpty()) {
                T.bw.write("0\n");
            }
            else {
                T.bw.write(String.valueOf(pQ.poll()) + "\n");
            }
        }

        T.bw.flush();
        T.bw.close();
    }
}