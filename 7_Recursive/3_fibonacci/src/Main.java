import java.io.*;

public class Main {
    static int[] fibo; // 메모이제이션용 전역 배열 생성 (모든 메소드가 이 배열 공유함)

    public int fibonacci(int n) {
        if(fibo[n] != 0) return fibo[n]; // 기존에 저장된 결과값 있으면, 그 값 바로 반환
        else if(n==1 || n==2) return fibo[n] = 1;
        else {
            return fibo[n] = fibonacci(n-2) + fibonacci(n-1); // n일때의 재귀 결과값을 배열에 저장
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Main T = new Main();

        fibo = new int[n+1]; // fibonacci 메소드 실행하기 전에, fibo 전역 배열을 먼저 초기화 해줘야지 값이 여기에 저장됨
        T.fibonacci(n);

        for(int i=1; i<=n; i++) {
            bw.write(String.valueOf(fibo[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}