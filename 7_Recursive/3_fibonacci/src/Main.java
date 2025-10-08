import java.io.*;

public class Main {
    public int fibonacci(int n) {
        if(n==1) return 1;
        else if(n==2) return fibonacci(n-1);
        else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Main T = new Main();

        for(int i=1; i<=n; i++) {
            bw.write(String.valueOf(T.fibonacci(i)) + " ");
        }

        bw.flush();
        bw.close();
    }
}