import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        // ** 메인 알고리즘 **
        // 1. 데이터 없을 때 : 기존 데이터 전부 오른쪽으로 한칸씩 이동 -> 맨 처음에 데이터 삽입
        // 2. 데이터 있을 때 : 해당 데이터의 왼쪽에 있던 값들 전부 한칸씩 오른쪽으로 이동 -> 맨 처음에 데이터 삽입

        // 캐시(answer)에 데이터 하나씩 비교하면서 삽입
        for(int i=0; i<n; i++) {
            int idx = 0;

            while(idx != s) { // cache 크기만큼 탐색
                if(answer[idx] == arr[i]) { // 1. 캐시에서 데이터 찾았을 떄 : 캐시의 인덱스(idx)까지, 왼쪽 데이터들 오른쪽 이동
                    for(int j=idx; j>0; j--) {
                        answer[j] = answer[j-1];
                    }
                    answer[0] = arr[i];

                    break;
                } else {
                    idx++;
                }
            }

            if(idx == s) { // 2. 캐시에서 데이터 못찾았을 때 : 한칸씩 오른쪽 이동 & 맨 왼쪽에 데이터 삽입
                for(int j=s-1; j>0; j--) {
                    answer[j] = answer[j-1];
                }
                answer[0] = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int x : T.solution(S, N, arr)) {
            bw.write(String.format(String.valueOf(x) + " "));
        }

        bw.close();
    }
}