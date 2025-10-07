import java.io.*;

public class Main {
    public int factorial(int n) {
        if(n==1) return 1;
        else return n * factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Main T = new Main();

        bw.write(String.valueOf(T.factorial(n)));

        bw.flush();
        bw.close();
    }
}