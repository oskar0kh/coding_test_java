import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++) { // 마지막 n번째 데이터는 비교할 필요 없음
            int index = i;
            int min = arr[i];

            for(int j=i+1; j<n-1; j++) { // 먼저, 배열에서 최솟값 찾기
                if(arr[j] < min) {
                    index = j;
                    min = arr[j];
                }
            }

            int tmp = arr[i]; // 그 다음, '최솟값 <-> i번 인덱스 값' 교체
            arr[i] = min;
            arr[index] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
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