import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j] < arr[j-1]) { // 자기 왼쪽값보다 작을때 -> 한칸씩 왼쪽으로 이동시키기
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                else break;
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int x : T.solution(N, arr)) {
            bw.write(String.format(String.valueOf(x) + " "));
        }

        bw.close();
    }
}