import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public Character solution(int n, int[] arr){
        char answer = 'U';

        for(int i=0; i<n; i++) {
            int cmp = arr[i];

            for(int j=0; j<n; j++) {
                if((j != i) && (cmp == arr[j])) {  // 자기 자신은 제외하고 비교
                    answer = 'D';
                    break;
                }
            }

            if(answer == 'D') break;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();
        bw.write(T.solution(N, arr));

        bw.close();
    }
}