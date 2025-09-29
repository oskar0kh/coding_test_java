import java.io.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution(int n) throws IOException {
        if(n == 0) return;
        else {
            solution(n/2);
            bw.write(String.valueOf(n%2));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main T = new Main();
        T.solution(n);

        T.bw.flush();
        T.bw.close();
    }
}